package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.SaleAdFilter;
import br.com.byron.luderia.domain.request.SaleAdRequest;
import br.com.byron.luderia.domain.response.SaleAdResponse;
import br.com.byron.luderia.domain.model.SaleAd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISaleAdMapper extends IGenericMapper<SaleAd, SaleAdRequest, SaleAdResponse, SaleAdFilter> {

//	@ObjectFactory
//	default Comment create(CommentRequest request) {
//		User user = new User();
//		user.setId(request.getUserId());
//		Comment comment = new Comment();
//		comment.setUser(user);
//		return comment;
//	}
	
}
