package Projeto_Estatistica.Service;

import Projeto_Estatistica.DTOs.RequestDTO;
import Projeto_Estatistica.DTOs.ResponseTaxaDTO;
import Projeto_Estatistica.Exceptions.DadosException;
import Projeto_Estatistica.Models.Taxa;
import Projeto_Estatistica.Repository.TaxaRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaxaService {

    @Autowired
    private TaxaRepository taxaRepository;

    /*essa função serve de apoio para a outra, evitando código
      grande na função principal do endpoint
    */

    public ResponseTaxaDTO calculos(@NonNull List<Taxa> lista){
        ResponseTaxaDTO responseTaxaDTO = new ResponseTaxaDTO();
        int size = lista.size();
        Double mediana;
        if(size%2!=0) {
            responseTaxaDTO.setMedian(lista.get((size / 2) + 1).getValor());
            Double percent_25 = lista.get((size / 4) + 1).getValor();
            Double percent_75 = lista.get((3*size/4)+1).getValor();
            responseTaxaDTO.setPercent25(percent_25);
            responseTaxaDTO.setPercent75(percent_75);
        }else {
            mediana = (lista.get((size / 2)).getValor() + lista.get((size / 2)+1).getValor())/2;
            responseTaxaDTO.setMedian(mediana);
            Double percent_25 = (lista.get((size / 4)).getValor() + lista.get((size / 4)+1).getValor())/2;
            Double percent_75 = (lista.get((3*size / 4)).getValor() + lista.get((3*size / 4)+1).getValor())/2;
            responseTaxaDTO.setPercent25(percent_25);
            responseTaxaDTO.setPercent75(percent_75);
        }
        Double mediaAritmetica;
        Double mediaGeometrica;

        Double somatoria = 0.0;
        Double produtorio = 1.0;
        for(Taxa taxa : lista){
            somatoria += taxa.getValor();
            produtorio *= taxa.getValor();
        }
        mediaAritmetica = somatoria / size;
        mediaGeometrica = (double)Math.round(Math.pow(produtorio,1.0/size));

        responseTaxaDTO.setAritMean(mediaAritmetica);
        responseTaxaDTO.setGeoMean(mediaGeometrica);

        return responseTaxaDTO;
    }

    public ResponseTaxaDTO calculosTaxa(@NonNull RequestDTO requestDTO){

        LocalDate inicio = LocalDate.parse(requestDTO.getFrom());
        LocalDate fim = LocalDate.parse(requestDTO.getTo());

        List<Taxa> dados = taxaRepository.findByDataBetweenOrderByValor(inicio,fim)
                .orElseThrow(()->new DadosException("Erro ao manipular os dados."));

        return calculos(dados);
    }
}
