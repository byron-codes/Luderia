package br.com.byron.luderia.strategy.strategies;

import br.com.byron.luderia.model.SaleChange;
import br.com.byron.luderia.model.SaleChangeItem;
import br.com.byron.luderia.model.SaleStatus;
import br.com.byron.luderia.repository.ISaleRepository;
import br.com.byron.luderia.repository.IUserRepository;
import br.com.byron.luderia.strategy.IStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaleChangeUpdateStrategy implements IStrategy<SaleChange> {

    private final IUserRepository userRepository;

    private final ISaleRepository saleRepository;

    @Override
    public void execute(SaleChange sale) {
        switch (sale.getChangeStatus()) {
            case SHIPMENT:
                //TODO enviar email com o codigo dos correios para postar o produto
                break;
            case FINISHED:
                double totalValue = sale.getSale().getBuyer().getBalance();
                for (SaleChangeItem item : sale.getItems()) {
                    if(item.getAuthorized()) {
                        totalValue += item.getQuantity() * item.getProduct().getValue();
                    }
                }
                sale.getSale().setSaleStatus(SaleStatus.EXCHANGEFINISHED);
                sale.getSale().getBuyer().setBalance(totalValue);
                break;
        }
        userRepository.save(sale.getSale().getBuyer());
        saleRepository.save(sale.getSale());
    }

}
