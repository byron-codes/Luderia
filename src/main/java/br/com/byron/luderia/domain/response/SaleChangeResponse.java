package br.com.byron.luderia.domain.response;

import br.com.byron.luderia.domain.request.IdRequest;
import br.com.byron.luderia.domain.enumerable.ChangeStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleChangeResponse extends GenericResponse {

	private Long id;

	private ChangeStatus changeStatus;

	private LocalDateTime creationDate;

	private IdRequest sale;
	
	private List<SaleChangeItemResponse> items;
	
}
