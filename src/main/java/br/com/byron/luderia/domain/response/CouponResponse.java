package br.com.byron.luderia.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouponResponse extends GenericResponse {

	private Long id;

	private String name;

	private Double value;

	private LocalDate expirationDate;

	private Integer quantity;

	private String code;

	private String description;
	
}
