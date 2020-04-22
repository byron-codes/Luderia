package br.com.byron.luderia.service;

import br.com.byron.luderia.dto.response.ShipmentResponse;
import br.com.techzee.correios.ws.ConsultaCorreios;
import br.com.techzee.correios.ws.dto.CorreiosPrecoPrazo;
import br.com.techzee.correios.ws.enumeration.CorreiosTipoServico;
import org.springframework.stereotype.Service;

@Service
public class FreightService {

    public ShipmentResponse calculate(String destination) {

        CorreiosPrecoPrazo correiosPrecoPrazo = null;
        ShipmentResponse shipmentResponse = new ShipmentResponse();

        try {
            correiosPrecoPrazo = new ConsultaCorreios().calcularPrecoPrazo("01451001", destination)[0];
            shipmentResponse.setFreight(correiosPrecoPrazo.getPrecoFrete());
            shipmentResponse.setDays(correiosPrecoPrazo.getPrazoEntrega());
        } catch (Exception e) {
            // e.printStackTrace();
            shipmentResponse.setFreight(22.5);
            shipmentResponse.setDays(4);
            shipmentResponse.setError(true);
        }

        return shipmentResponse;
    }

}
