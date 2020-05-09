package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.ImageFilter;
import br.com.byron.luderia.domain.request.ImageRequest;
import br.com.byron.luderia.domain.response.ImageResponse;
import br.com.byron.luderia.domain.model.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IImageMapper extends IGenericMapper<Image, ImageRequest, ImageResponse, ImageFilter>{

}
