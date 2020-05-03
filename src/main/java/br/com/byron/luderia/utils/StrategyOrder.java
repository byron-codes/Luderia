package br.com.byron.luderia.utils;

import br.com.byron.luderia.model.Product;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.model.SaleChange;
import br.com.byron.luderia.strategy.strategies.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class StrategyOrder {

    private final Map<String, List<String>> saveOrder;

    private final Map<String, List<String>> updateOrder;

    public StrategyOrder() {
        Map<String, List<String>> saveMap = new HashMap<>();

        saveMap.put(Sale.class.getSimpleName(), generateList(SaleSaveStrategy.class));
        saveMap.put(SaleChange.class.getSimpleName(), generateList(SaleQuantityStrategy.class, SaleChangeSaveStrategy.class));
        saveMap.put(Product.class.getSimpleName(), generateList(ProductSaveStrategy.class));

        this.saveOrder = saveMap;

        Map<String, List<String>> updateMap = new HashMap<>();

        updateMap.put(SaleChange.class.getSimpleName(), generateList(SaleChangeUpdateStrategy.class));

        this.updateOrder = updateMap;
    }

    private List<String> generateList(Class ...items) {
        List<String> itemList = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            itemList.add(firstLower(items[i].getSimpleName()));
        }
        return itemList;
    }

    private String firstLower(String text) {
        return new StringBuilder().append(text.substring(0, 1).toLowerCase()).append(text.substring(1)).toString();
    }

}
