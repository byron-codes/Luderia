package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.byron.luderia.dto.filter.CommentFilter;
import br.com.byron.luderia.dto.request.CommentRequest;
import br.com.byron.luderia.dto.response.CommentResponse;
import br.com.byron.luderia.model.Comment;

@Mapper(componentModel = "spring")
public interface ICommentMapper extends IGenericMapper<Comment, CommentRequest, CommentResponse, CommentFilter> {

	@Mappings({ @Mapping(source = "userId", target = "user.id"), @Mapping(source = "saleAdId", target = "saleAd.id") })
	public Comment toEntity(CommentRequest request);

	@Mappings({ @Mapping(source = "resquest.userId", target = "user.id"),
			@Mapping(source = "resquest.saleAdId", target = "saleAd.id") })
	public Comment toUpdateEntity(CommentRequest resquest, Long id);

}
