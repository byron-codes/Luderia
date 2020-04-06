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
        try {
            correiosPrecoPrazo = new ConsultaCorreios().calcularPrecoPrazo("01451001", destination)[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

        ShipmentResponse shipmentResponse = new ShipmentResponse();
        shipmentResponse.setFreight(correiosPrecoPrazo.getPrecoFrete());
        shipmentResponse.setDays(correiosPrecoPrazo.getPrazoEntrega());
        return shipmentResponse;
    }

}
