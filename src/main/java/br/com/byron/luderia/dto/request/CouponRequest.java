package br.com.byron.luderia.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouponRequest extends GenericRequest {

	private String name;
	
	private Double value;
	
	private LocalDate expirationDate;
	
	private Integer quatity;
	
}
