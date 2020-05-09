package br.com.byron.luderia.domain.mapper;

import br.com.byron.luderia.domain.filter.SaleFilter;
import br.com.byron.luderia.domain.request.SaleRequest;
import br.com.byron.luderia.domain.response.SaleResponse;
import br.com.byron.luderia.domain.model.Sale;
import br.com.byron.luderia.domain.model.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ICouponMapper.class, ISaleItemMapper.class, ICreditCardMapper.class})
public interface ISaleMapper extends IGenericMapper<Sale, SaleRequest, SaleResponse, SaleFilter> {

    @Mappings({
            @Mapping(source = "user", target = "buyer")
    })
    public Sale toEntity(SaleRequest request);

    public Sale toEntity(Long id, SaleStatus saleStatus);

/*    @Mappings({
            @Mapping(source = "resquest.userId", target = "buyer.id"),
            @Mapping(source = "resquest.addressId", target = "address.id")
    })
    public Sale toUpdateEntity(SaleRequest resquest, Long id);*/

//	@ObjectFactory
//	default SaleItem create(SaleItemRequest response) {
//		SaleItem saleItem = new SaleItem();
//		SaleAd saleAd = new SaleAd();
//		saleAd.setId(response.getAdId());
//		saleItem.setAd(saleAd);
//		return saleItem;
//	}

}
