package Projeto_Estatistica.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ResponseInvestimentosDTO {
    private Double mean;
    private Double median;
    private Double percent25;
    private Double percent75;

    public ResponseInvestimentosDTO() {
    }
}
