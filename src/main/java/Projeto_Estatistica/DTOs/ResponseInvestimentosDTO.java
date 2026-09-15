package Projeto_Estatistica.DTOs;

import java.util.ArrayList;

public class ResponseInvestimentosDTO {
    private Double mean;
    private Double median;
    private ArrayList<Double> monthlyMeans;
    private Double percent25;
    private Double percent75;

    public ResponseInvestimentosDTO(){
    }
}
