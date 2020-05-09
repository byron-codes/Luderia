package br.com.byron.luderia.strategy.strategies;

import br.com.byron.luderia.domain.model.ChangeStatus;
import br.com.byron.luderia.domain.model.SaleChange;
import br.com.byron.luderia.domain.model.SaleStatus;
import br.com.byron.luderia.repository.ISaleChangeItemRepository;
import br.com.byron.luderia.repository.ISaleRepository;
import br.com.byron.luderia.strategy.IStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaleChangeSaveStrategy implements IStrategy<SaleChange> {

    private final ISaleChangeItemRepository saleChangeItemRepository;

    private final ISaleRepository saleRepository;

    @Override
    public void execute(SaleChange saleChange) {
        saleChange.setSale(saleRepository.findById(saleChange.getSale().getId()).get());
        saleChange.getSale().setSaleStatus(SaleStatus.EXCHANGE);
        saleRepository.save(saleChange.getSale());
        saleChange.setChangeStatus(ChangeStatus.PROCESSING);
        saleChange.getItems().stream().forEach(saleChangeItem -> saleChangeItemRepository.save(saleChangeItem));
    }

}
