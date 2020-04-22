package br.com.byron.luderia.service;

import br.com.byron.luderia.dto.filter.SaleChangeFilter;
import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.model.*;
import br.com.byron.luderia.repository.IAddressRepository;
import br.com.byron.luderia.repository.ISaleChangeRepository;
import br.com.byron.luderia.repository.ISaleRepository;
import br.com.byron.luderia.repository.specification.SaleChangeSpecification;
import br.com.byron.luderia.repository.specification.SaleSpecification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleChangeService extends GenericService<SaleChange, SaleChangeFilter> {

    private ISaleChangeRepository repository;

    private SaleChangeItemService saleChangeItemService;

    private SaleService saleService;

    private UserService userService;

    SaleChangeService(ISaleChangeRepository repository, SaleChangeItemService saleChangeItemService,
                      SaleService saleService, UserService userService) {
        super(repository);
        this.repository = repository;
        this.saleChangeItemService = saleChangeItemService;
        this.saleService = saleService;
        this.userService = userService;
    }

    @Override
    public List<SaleChange> find(SaleChangeFilter filter) {
        return repository.findAll(new SaleChangeSpecification(filter));
    }

    @Override
    public SaleChange add(SaleChange entity) {
        SaleFilter saleFilter = new SaleFilter();
        saleFilter.setId(entity.getSale().getId());
        entity.setSale(saleService.find(saleFilter).get(0));
        entity.getSale().setSaleStatus(SaleStatus.EXCHANGE);
        saleService.update(entity.getSale());
        entity.setChangeStatus(ChangeStatus.PROCESSING);
        entity.getItems().stream().forEach(saleChangeItem -> saleChangeItemService.add(saleChangeItem));
        return super.add(entity);
    }

    @Override
    public SaleChange update(SaleChange entity) {
        switch (entity.getChangeStatus()) {
            case SHIPMENT:
                //TODO enviar email com o codigo dos correios para postar o produto
                break;
            case FINISHED:
                double totalValue = entity.getSale().getBuyer().getBalance();
                for (SaleChangeItem item : entity.getItems()) {
                    if(item.getAuthorized()) {
                        totalValue += item.getQuantity() * item.getProduct().getValue();
                    }
                }
                entity.getSale().setSaleStatus(SaleStatus.EXCHANGEFINISHED);
                entity.getSale().getBuyer().setBalance(totalValue);
                break;
        }
        userService.update(entity.getSale().getBuyer());
        saleService.update(entity.getSale());
        return super.update(entity);
    }
}
