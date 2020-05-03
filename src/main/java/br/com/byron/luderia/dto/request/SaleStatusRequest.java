package br.com.byron.luderia.dto.request;

import br.com.byron.luderia.model.SaleStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleStatusRequest {

    @NotNull
    private SaleStatus saleStatus;

}
