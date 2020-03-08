package br.com.byron.luderia.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
