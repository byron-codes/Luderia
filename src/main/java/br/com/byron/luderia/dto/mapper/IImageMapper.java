package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.ImageFilter;
import br.com.byron.luderia.dto.request.ImageRequest;
import br.com.byron.luderia.dto.response.ImageResponse;
import br.com.byron.luderia.model.Image;

@Mapper(componentModel = "spring")
public interface IImageMapper extends IGenericMapper<Image, ImageRequest, ImageResponse, ImageFilter>{

}
