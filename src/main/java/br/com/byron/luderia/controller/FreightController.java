package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.response.ShipmentResponse;
import br.com.byron.luderia.service.FreightService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/freight")
@Api(value = "Freight")
public class FreightController {

    @Autowired
    private FreightService freightService;

    @GetMapping("/{destination}")
    public ResponseEntity<ShipmentResponse> calculate(@PathVariable("destination") String destination){
        return ResponseEntity.ok(freightService.calculate(destination));
    }

}
