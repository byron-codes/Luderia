package br.com.byron.luderia.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest extends GenericRequest {

	private String description;

	private Double rating;
	
	private Long userId;
	
	private Long saleAdId;
	
}
