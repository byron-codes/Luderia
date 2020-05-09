package br.com.byron.luderia.domain.filter;

import br.com.byron.luderia.domain.model.SaleStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleFilter extends GenericFilter {

    private SaleStatus saleStatus;

}
