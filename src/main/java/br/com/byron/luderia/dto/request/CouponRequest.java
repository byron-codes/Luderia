package br.com.byron.luderia.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouponRequest extends GenericRequest {

	@NotBlank(message = "O nome não pode ser vazio")
	@Length(min = 5, max = 150, message = "O tamanho do nome deve estar entre 5 e 150 caracteres")
	private String name;

	@NotNull(message = "O valor do cupom não pode ser vazio")
	@Positive(message = "O valor do cupom deve ser positivo")
	private Double value;

	@NotNull(message = "A data de válidade é obrigatória")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Future(message = "A data deve ser posterior a data atual")
	private LocalDate expirationDate;

	@NotNull(message = "A quantidade do cupom não pode ser vazio")
	@Positive(message = "A quantidade do cupom deve ser positiva")
	private Integer quantity;

	@NotBlank(message = "O código não pode ser vazio")
	@Length(min = 5, max = 15, message = "O tamanho da código deve estar entre 5 e 15 caracteres")
	private String code;

	@NotBlank(message = "A descrição não pode ser vazia")
	@Length(min = 5, max = 150, message = "O tamanho da descrição deve estar entre 5 e 150 caracteres")
	private String description;
	
}
