package Projeto_Estatistica.Repository;

import Projeto_Estatistica.Models.Investimentos;
import Projeto_Estatistica.Models.Taxa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaxaRepository extends JpaRepository<Taxa,Long> {
    Optional<List<Taxa>> findByDataBetweenOrderByValor(LocalDate inicio, LocalDate fim);
}
