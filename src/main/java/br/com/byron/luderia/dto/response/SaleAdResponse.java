package br.com.byron.luderia.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleAdResponse extends GenericResponse {

	private Long id;
	
	private ProductResponse product;
	
	private List<CommentResponse> comments;
	
}
