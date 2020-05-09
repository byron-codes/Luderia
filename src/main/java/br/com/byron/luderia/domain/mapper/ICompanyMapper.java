package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.CompanyFilter;
import br.com.byron.luderia.domain.request.CompanyRequest;
import br.com.byron.luderia.domain.response.CompanyResponse;
import br.com.byron.luderia.domain.model.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICompanyMapper extends IGenericMapper<Company, CompanyRequest, CompanyResponse, CompanyFilter>{

}