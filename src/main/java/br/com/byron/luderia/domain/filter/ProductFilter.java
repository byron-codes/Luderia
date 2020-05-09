package br.com.byron.luderia.domain.filter;

import br.com.byron.luderia.domain.model.GameLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductFilter extends GenericFilter {

    private Double max;

    private Double min;

    private List<GameLevel> levelList;

    private String name;

    private Boolean game;

    private Boolean expansion;

    private Boolean accessory;

}
