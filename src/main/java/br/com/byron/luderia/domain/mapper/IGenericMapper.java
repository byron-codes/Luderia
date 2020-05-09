package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.GenericFilter;
import br.com.byron.luderia.domain.request.GenericRequest;
import br.com.byron.luderia.domain.response.GenericResponse;
import br.com.byron.luderia.domain.model.GenericEntity;

import java.util.List;

public interface IGenericMapper<Entity extends GenericEntity, Request extends GenericRequest, Response extends GenericResponse, Filter extends GenericFilter> {

	public Entity toEntity(Request request);

	public Entity toEntity(Long id);
	
	public List<Entity> toEntity(List<Long> id);
	
	public Response toResponse(Entity entity);
	
	public List<Response> toResponse(List<Entity> entity);
	
	public Filter toFilter(Long id);
	
	public Entity toUpdateEntity(Request resquest, Long id);
	
}
