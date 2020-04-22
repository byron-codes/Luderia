package br.com.byron.luderia.service;

import br.com.byron.luderia.dto.response.LineChartItem;
import br.com.byron.luderia.model.Sale;
import br.com.byron.luderia.model.SaleChange;
import br.com.byron.luderia.model.SaleItem;
import br.com.byron.luderia.repository.ISaleChangeRepository;
import br.com.byron.luderia.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ISaleRepository saleRepository;

    private final ISaleChangeRepository saleChangeRepository;

    public List<LineChartItem> getSalesYear(Integer year) {

        LocalDateTime startDate = LocalDate.parse(year + "-01-01").atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(year + "-12-31").atTime(23, 59);

        LineChartItem games = new LineChartItem("GAME");
        LineChartItem expansions = new LineChartItem("EXPANSION");
        LineChartItem accessories = new LineChartItem("ACCESSORIES");

        List<Sale> sales = saleRepository.getByPeriod(startDate, endDate);

        for (Sale sale : sales) {
            Integer monthValue = sale.getCreationDate().getMonth().getValue();
            for (SaleItem item : sale.getItems()) {
                switch (item.getProduct().getDiscriminator()) {
                    case "GAME":
                        games.getValues().put(monthValue, games.getValues().get(monthValue) + item.getQuantity());
                        break;
                    case "EXPANSION":
                        expansions.getValues().put(monthValue, expansions.getValues().get(monthValue) + item.getQuantity());
                        break;
                    case "ACCESSORIES":
                        accessories.getValues().put(monthValue, accessories.getValues().get(monthValue) + item.getQuantity());
                        break;
                    default:
                        break;
                }
            }
        }

        return Arrays.asList(games, expansions, accessories);

    }

    public List<LineChartItem> getSalesAndChanges(Integer year) {

        LocalDateTime startDate = LocalDate.parse(year + "-01-01").atStartOfDay();
        LocalDateTime endDate = LocalDate.parse(year + "-12-31").atTime(23, 59);

        LineChartItem salesReport = new LineChartItem("SALE");
        LineChartItem changesReport = new LineChartItem("CHANGE");

        List<Sale> sales = saleRepository.getByPeriod(startDate, endDate);
        List<SaleChange> changes = saleChangeRepository.getByPeriod(startDate, endDate);


        for (Sale sale : sales) {
            Integer monthValue = sale.getCreationDate().getMonth().getValue();
            salesReport.getValues().put(monthValue, salesReport.getValues().get(monthValue) + 1);
        }

        for (SaleChange change : changes) {
            Integer monthValue = change.getCreationDate().getMonth().getValue();
            changesReport.getValues().put(monthValue, changesReport.getValues().get(monthValue) + 1);
        }

        return Arrays.asList(salesReport, changesReport);

    }

}
