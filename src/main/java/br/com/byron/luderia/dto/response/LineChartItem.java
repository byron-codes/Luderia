package br.com.byron.luderia.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class LineChartItem {

    public LineChartItem(String name) {
        values = new LinkedHashMap<>();
        for (int i = 1; i < 13; i++) {
            values.put(i, 0);
        }
        this.name = name;
    }

    private String name;

    private Map<Integer, Integer> values;

}
