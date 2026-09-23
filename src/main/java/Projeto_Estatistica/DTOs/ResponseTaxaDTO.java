package Projeto_Estatistica.DTOs;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ResponseTaxaDTO {
    private final Double mean;
    private final Double median;
    private final ArrayList<Double> monthlyMeans;
    private final Double percent25;
    private final Double percent75;

    public ResponseTaxaDTO(Double mean, Double median, ArrayList<Double> monthlyMeans, Double percent25, Double percent75) {
        this.mean = mean;
        this.median = median;
        this.monthlyMeans = monthlyMeans;
        this.percent25 = percent25;
        this.percent75 = percent75;
    }
}
