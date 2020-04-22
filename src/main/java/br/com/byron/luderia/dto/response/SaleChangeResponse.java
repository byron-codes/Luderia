package br.com.byron.luderia.dto.response;

import br.com.byron.luderia.dto.request.GenericRequest;
import br.com.byron.luderia.dto.request.IdRequest;
import br.com.byron.luderia.model.ChangeStatus;
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
