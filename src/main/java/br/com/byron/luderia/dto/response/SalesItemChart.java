package br.com.byron.luderia.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesItemChart {

    private LineChartItem games;

    private LineChartItem expansions;

    private LineChartItem accessories;

}
