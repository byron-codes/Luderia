package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.ImageFilter;
import br.com.byron.luderia.dto.request.ImageRequest;
import br.com.byron.luderia.dto.response.ImageResponse;
import br.com.byron.luderia.model.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IImageMapper extends IGenericMapper<Image, ImageRequest, ImageResponse, ImageFilter>{

}
