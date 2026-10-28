package Projeto_Estatistica.Service;

import Projeto_Estatistica.DTOs.RequestDTO;
import Projeto_Estatistica.DTOs.ResponseInvestimentosDTO;
import Projeto_Estatistica.Exceptions.DadosException;
import Projeto_Estatistica.Models.Investimentos;
import Projeto_Estatistica.Models.Taxa;
import Projeto_Estatistica.Repository.InvestimentosRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvestimentosService{
    @Autowired
    private InvestimentosRepository investimentosRepository;

    // essa função é auxiliar, e complementa a função principal
    public ResponseInvestimentosDTO calculos(@NonNull List<Investimentos> lista){
        ResponseInvestimentosDTO response = new ResponseInvestimentosDTO();

        int size = lista.size();
        Double mediana;
        if(size%2!=0) {
            response.setMedian(lista.get((size / 2) + 1).getValor());
            Double percent_25 = lista.get((size / 4) + 1).getValor();
            Double percent_75 = lista.get((3*size/4)+1).getValor();
            response.setPercent25(percent_25);
            response.setPercent75(percent_75);
        }else {
            mediana = (lista.get((size / 2)).getValor() + lista.get((size / 2)+1).getValor())/2;
            response.setMedian(mediana);
            Double percent_25 = (lista.get((size / 4)).getValor() + lista.get((size / 4)+1).getValor())/2;
            Double percent_75 = (lista.get((3*size / 4)).getValor() + lista.get((3*size / 4)+1).getValor())/2;
            response.setPercent25(percent_25);
            response.setPercent75(percent_75);
        }
        Double mediaAritmetica;
        Double mediaGeometrica;

        Double somatoria = 0.0;
        Double produtorio = 1.0;
        for(Investimentos investimentos : lista){
            somatoria += investimentos.getValor();
            produtorio *= investimentos.getValor();
        }
        mediaAritmetica = somatoria / size;
        mediaGeometrica = (double)Math.round(Math.pow(produtorio,1.0/size));

        response.setAritMean(mediaAritmetica);
        response.setGeoMean(mediaGeometrica);

        return response;
    }
    public ResponseInvestimentosDTO calculoInvestimentos(@NonNull RequestDTO requestDTO){

        LocalDate inicio = LocalDate.parse(requestDTO.getFrom());
        LocalDate fim = LocalDate.parse(requestDTO.getTo());

        List<Investimentos> lista = investimentosRepository.findByDataBetweenOrderByValor(inicio,fim)
                .orElseThrow(()->new DadosException("Erro ao manipular os dados."));

        return calculos(lista);
    }

}
