package br.com.byron.luderia.dto.filter;

import br.com.byron.luderia.dto.request.IdRequest;
import br.com.byron.luderia.dto.response.GenericResponse;
import br.com.byron.luderia.dto.response.SaleChangeItemResponse;
import br.com.byron.luderia.model.ChangeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaleChangeFilter extends GenericFilter {

    private ChangeStatus changeStatus;

}
