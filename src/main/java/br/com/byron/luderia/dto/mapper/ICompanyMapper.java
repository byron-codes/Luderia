package br.com.byron.luderia.dto.mapper;

import br.com.byron.luderia.dto.filter.CompanyFilter;
import br.com.byron.luderia.dto.request.CompanyRequest;
import br.com.byron.luderia.dto.response.CompanyResponse;
import br.com.byron.luderia.model.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICompanyMapper extends IGenericMapper<Company, CompanyRequest, CompanyResponse, CompanyFilter>{

}