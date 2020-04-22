package br.com.byron.luderia.service;

import br.com.byron.luderia.dto.filter.SaleChangeFilter;
import br.com.byron.luderia.dto.filter.SaleChangeItemFilter;
import br.com.byron.luderia.model.SaleChange;
import br.com.byron.luderia.model.SaleChangeItem;
import br.com.byron.luderia.repository.ISaleChangeItemRepository;
import br.com.byron.luderia.repository.ISaleChangeRepository;
import br.com.byron.luderia.repository.specification.SaleChangeItemSpecification;
import br.com.byron.luderia.repository.specification.SaleChangeSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleChangeItemService extends GenericService<SaleChangeItem, SaleChangeItemFilter> {

    private ISaleChangeItemRepository repository;

    SaleChangeItemService(ISaleChangeItemRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<SaleChangeItem> find(SaleChangeItemFilter filter) {
        return repository.findAll(new SaleChangeItemSpecification(filter));
    }
}
