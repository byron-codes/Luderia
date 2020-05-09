package br.com.byron.luderia.service;

import br.com.byron.luderia.domain.response.LineChartItem;
import br.com.byron.luderia.domain.response.ReportType;
import br.com.byron.luderia.domain.model.Sale;
import br.com.byron.luderia.domain.model.SaleChange;
import br.com.byron.luderia.domain.model.SaleItem;
import br.com.byron.luderia.repository.ISaleChangeRepository;
import br.com.byron.luderia.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ISaleRepository saleRepository;

    private final ISaleChangeRepository saleChangeRepository;

    public List<LineChartItem> getSalesYear(LocalDate startDate, LocalDate endDate, ReportType type) {

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59);

        LineChartItem gameReport = new LineChartItem("GAME");
        LineChartItem expansionsReport = new LineChartItem("EXPANSION");
        LineChartItem accessoriesReport = new LineChartItem("ACCESSORIES");

        List<Sale> sales = saleRepository.getByPeriod(startDateTime, endDateTime);
        DateTimeFormatter formatter = null;


        switch (type) {
            case DAILY:
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
                    gameReport.getValues().put(formatter.format(startDate), 0);
                    expansionsReport.getValues().put(formatter.format(startDate), 0);
                    accessoriesReport.getValues().put(formatter.format(startDate), 0);
                    startDate = startDate.plusDays(1);
                }
                break;
            case MONTHLY:
                formatter = DateTimeFormatter.ofPattern("MM/yyyy");
                while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
                    gameReport.getValues().put(formatter.format(startDate), 0);
                    expansionsReport.getValues().put(formatter.format(startDate), 0);
                    accessoriesReport.getValues().put(formatter.format(startDate), 0);
                    startDate = startDate.plusMonths(1);
                }
                break;
            case YEARLY:
                formatter = DateTimeFormatter.ofPattern("yyyy");
                while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
                    gameReport.getValues().put(formatter.format(startDate), 0);
                    expansionsReport.getValues().put(formatter.format(startDate), 0);
                    accessoriesReport.getValues().put(formatter.format(startDate), 0);
                    startDate = startDate.plusYears(1);
                }
                break;
        }

        for (Sale sale : sales) {
            String date = formatter.format(sale.getCreationDate().toLocalDate());
            for (SaleItem item : sale.getItems()) {
                switch (item.getProduct().getDiscriminator()) {
                    case "GAME":
                        gameReport.getValues().put(date, Integer.parseInt(gameReport.getValues().get(date).toString()) + item.getQuantity());
                        break;
                    case "EXPANSION":
                        expansionsReport.getValues().put(date, Integer.parseInt(expansionsReport.getValues().get(date).toString()) + item.getQuantity());
                        break;
                    case "ACCESSORIES":
                        accessoriesReport.getValues().put(date, Integer.parseInt(accessoriesReport.getValues().get(date).toString()) + item.getQuantity());
                        break;
                    default:
                        break;
                }
            }
        }

        return Arrays.asList(gameReport, expansionsReport, accessoriesReport);

    }

    public List<LineChartItem> getSalesAndChanges(LocalDate startDate, LocalDate endDate, ReportType type) {

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59);

        LineChartItem salesReport = new LineChartItem("SALE");
        LineChartItem changesReport = new LineChartItem("CHANGE");

        List<Sale> sales = saleRepository.getByPeriod(startDateTime, endDateTime);
        List<SaleChange> changes = saleChangeRepository.getByPeriod(startDateTime, endDateTime);
        DateTimeFormatter formatter;


        switch (type) {
            case DAILY:
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
                    salesReport.getValues().put(formatter.format(startDate), 0);
                    changesReport.getValues().put(formatter.format(startDate), 0);
                    startDate = startDate.plusDays(1);
                }

                for (Sale sale : sales) {
                    String date = formatter.format(sale.getCreationDate().toLocalDate());
                    salesReport.getValues().put(date, Integer.parseInt(salesReport.getValues().get(date).toString()) + 1);
                }

                for (SaleChange change : changes) {
                    String date = formatter.format(change.getCreationDate().toLocalDate());
                    changesReport.getValues().put(date, Integer.parseInt(changesReport.getValues().get(date).toString()) + 1);
                }
                break;
            case MONTHLY:
                formatter = DateTimeFormatter.ofPattern("MM/yyyy");
                while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
                    salesReport.getValues().put(formatter.format(startDate), 0);
                    changesReport.getValues().put(formatter.format(startDate), 0);
                    startDate = startDate.plusMonths(1);
                }

                for (Sale sale : sales) {
                    String date = formatter.format(sale.getCreationDate().toLocalDate());
                    salesReport.getValues().put(date, Integer.parseInt(salesReport.getValues().get(date).toString()) + 1);
                }

                for (SaleChange change : changes) {
                    String date = formatter.format(change.getCreationDate().toLocalDate());
                    changesReport.getValues().put(date, Integer.parseInt(changesReport.getValues().get(date).toString()) + 1);
                }
                break;
            case YEARLY:
                formatter = DateTimeFormatter.ofPattern("yyyy");
                while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
                    salesReport.getValues().put(formatter.format(startDate), 0);
                    changesReport.getValues().put(formatter.format(startDate), 0);
                    startDate = startDate.plusYears(1);
                }

                for (Sale sale : sales) {
                    String date = formatter.format(sale.getCreationDate().toLocalDate());
                    salesReport.getValues().put(date, Integer.parseInt(salesReport.getValues().get(date).toString()) + 1);
                }

                for (SaleChange change : changes) {
                    String date = formatter.format(change.getCreationDate().toLocalDate());
                    changesReport.getValues().put(date, Integer.parseInt(changesReport.getValues().get(date).toString()) + 1);
                }
                break;
        }

        return Arrays.asList(salesReport, changesReport);

    }

}
