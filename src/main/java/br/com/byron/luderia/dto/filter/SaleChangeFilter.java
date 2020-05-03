package br.com.byron.luderia.dto.filter;

import br.com.byron.luderia.model.ChangeStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaleChangeFilter extends GenericFilter {

    private ChangeStatus changeStatus;

}
