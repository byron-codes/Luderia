package br.com.byron.luderia.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.byron.luderia.dto.filter.SaleFilter;
import br.com.byron.luderia.dto.request.SaleRequest;
import br.com.byron.luderia.dto.response.SaleResponse;
import br.com.byron.luderia.model.Sale;

@Mapper(componentModel = "spring", uses = { ICouponMapper.class, ISaleItemMapper.class })
public interface ISaleMapper extends IGenericMapper<Sale, SaleRequest, SaleResponse, SaleFilter> {

	@Mapping(source = "userId", target = "buyer.id")
	public Sale toEntity(SaleRequest request);

	@Mapping(source = "resquest.userId", target = "buyer.id")
	public Sale toUpdateEntity(SaleRequest resquest, Long id);

//	@ObjectFactory
//	default SaleItem create(SaleItemRequest response) {
//		SaleItem saleItem = new SaleItem();
//		SaleAd saleAd = new SaleAd();
//		saleAd.setId(response.getAdId());
//		saleItem.setAd(saleAd);
//		return saleItem;
//	}

}
