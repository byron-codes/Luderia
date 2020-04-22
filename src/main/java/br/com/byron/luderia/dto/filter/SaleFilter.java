package br.com.byron.luderia.dto.filter;

import br.com.byron.luderia.model.SaleStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleFilter extends GenericFilter {

    private SaleStatus saleStatus;

}
