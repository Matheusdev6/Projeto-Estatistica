package Projeto_Estatistica.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTaxaDTO {
    private Double median;
    private Double GeoMean;
    private Double AritMean;
    private Double percent25;
    private Double percent75;

    public ResponseTaxaDTO() {
    }
}
