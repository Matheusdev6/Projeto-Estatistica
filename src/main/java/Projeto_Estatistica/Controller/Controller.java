package Projeto_Estatistica.Controller;

import Projeto_Estatistica.DTOs.RequestDTO;
import Projeto_Estatistica.DTOs.ResponseInvestimentosDTO;
import Projeto_Estatistica.DTOs.ResponseTaxaDTO;
import Projeto_Estatistica.Service.InvestimentosService;
import Projeto_Estatistica.Service.TaxaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/estatistica")
public class Controller {

    @Autowired
    private TaxaService taxaService;


    @GetMapping("/calculos")
    public ResponseTaxaDTO getEstatistica(@RequestBody RequestDTO requestDTO) {
        return taxaService.calculosTaxa(requestDTO);
    }

    // rodar e resolver erros.
}
