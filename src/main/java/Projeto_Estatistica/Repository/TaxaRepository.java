package Projeto_Estatistica.Repository;

import Projeto_Estatistica.Models.Taxa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaxaRepository extends JpaRepository<Taxa,Long> {
    @Query("select t.valor , t.data from taxa_selic t where data BETWEEN t.from AND t.to ORDER BY valor")
    Optional<List<Taxa>> selectTaxas(LocalDate from, LocalDate to);
}
