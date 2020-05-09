package br.com.byron.luderia.domain.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class LineChartItem {

    private final String name;

    private Map<Object, Object> values =  new LinkedHashMap<>();

}
