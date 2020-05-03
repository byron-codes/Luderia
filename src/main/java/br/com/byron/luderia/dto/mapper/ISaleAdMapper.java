package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.SaleAdFilter;
import br.com.byron.luderia.dto.request.SaleAdRequest;
import br.com.byron.luderia.dto.response.SaleAdResponse;
import br.com.byron.luderia.model.SaleAd;
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
