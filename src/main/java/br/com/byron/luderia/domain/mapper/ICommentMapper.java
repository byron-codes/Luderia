package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.CommentFilter;
import br.com.byron.luderia.domain.request.CommentRequest;
import br.com.byron.luderia.domain.response.CommentResponse;
import br.com.byron.luderia.domain.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICommentMapper extends IGenericMapper<Comment, CommentRequest, CommentResponse, CommentFilter> {

	@Mappings({ @Mapping(source = "userId", target = "user.id"), @Mapping(source = "saleAdId", target = "saleAd.id") })
	public Comment toEntity(CommentRequest request);

	@Mappings({ @Mapping(source = "resquest.userId", target = "user.id"),
			@Mapping(source = "resquest.saleAdId", target = "saleAd.id") })
	public Comment toUpdateEntity(CommentRequest resquest, Long id);

}
