package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;

import br.com.byron.luderia.dto.filter.CompanyFilter;
import br.com.byron.luderia.dto.request.CompanyRequest;
import br.com.byron.luderia.dto.response.CompanyResponse;
import br.com.byron.luderia.model.Company;

@Mapper(componentModel = "spring")
public interface ICompanyMapper extends IGenericMapper<Company, CompanyRequest, CompanyResponse, CompanyFilter>{

}