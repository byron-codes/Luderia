package br.com.byron.luderia.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesItemChart {

    private LineChartItem games;

    private LineChartItem expansions;

    private LineChartItem accessories;

}
