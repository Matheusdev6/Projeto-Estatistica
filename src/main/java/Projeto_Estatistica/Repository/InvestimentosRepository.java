package Projeto_Estatistica.Repository;

import Projeto_Estatistica.Models.Investimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InvestimentosRepository extends JpaRepository<Investimentos,Long> {
    @Query("select i from investimento_direto i where data BETWEEN i.from AND i.to ORDER BY valor")
    Optional<List<Investimentos>> selectInvestimentos(LocalDate from, LocalDate to);
}
