package br.com.byron.luderia.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleAdResponse extends GenericResponse {

	private Long id;
	
	private ProductResponse product;
	
	private List<CommentResponse> comments;
	
}
