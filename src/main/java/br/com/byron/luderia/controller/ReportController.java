package br.com.byron.luderia.controller;

import br.com.byron.luderia.dto.request.ReportPeriodRequest;
import br.com.byron.luderia.dto.response.GameResponse;
import br.com.byron.luderia.dto.response.LineChartItem;
import br.com.byron.luderia.dto.response.LineChartItemMonth;
import br.com.byron.luderia.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/report")
@Api(value = "Report")
@ApiResponses({@ApiResponse(code = 201, message = "Created", response = GameResponse.class),
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request")})
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/item-type/period")
    public ResponseEntity<List<LineChartItem>> salesYear(@Valid ReportPeriodRequest reportPeriodRequest) {
        return ResponseEntity.ok(reportService.getSalesYear(reportPeriodRequest.getStartDate(), reportPeriodRequest.getEndDate(), reportPeriodRequest.getType()));
    }

    @GetMapping("/sale-change/period")
    public ResponseEntity<List<LineChartItem>> salesAndChangesPeriod(@Valid ReportPeriodRequest reportPeriodRequest) {
        return ResponseEntity.ok(reportService.getSalesAndChanges(reportPeriodRequest.getStartDate(), reportPeriodRequest.getEndDate(), reportPeriodRequest.getType()));
    }

}
