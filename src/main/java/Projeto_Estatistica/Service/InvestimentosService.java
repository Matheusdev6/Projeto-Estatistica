package Projeto_Estatistica.Service;

import Projeto_Estatistica.DTOs.RequestDTO;
import Projeto_Estatistica.DTOs.ResponseInvestimentosDTO;
import Projeto_Estatistica.Exceptions.DadosException;
import Projeto_Estatistica.Models.Investimentos;
import Projeto_Estatistica.Repository.InvestimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class InvestimentosService{
    @Autowired
    private InvestimentosRepository investimentosRepository;


    public ResponseInvestimentosDTO calculos(List<Investimentos> lista){
        ResponseInvestimentosDTO response = new ResponseInvestimentosDTO();

        // fazer essa função, integrar no controller, e testar aplicação
    }
    public ResponseInvestimentosDTO calculoInvestimentos(RequestDTO requestDTO){

        LocalDate inicio = LocalDate.parse(requestDTO.getFrom());
        LocalDate fim = LocalDate.parse(requestDTO.getTo());

        List<Investimentos> lista = investimentosRepository.selectInvestimentos(inicio,fim)
                .orElseThrow(()->new DadosException("Erro ao manipular os dados."));


    }

}
