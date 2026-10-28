package Projeto_Estatistica.Repository;

import Projeto_Estatistica.Models.Investimentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface InvestimentosRepository extends JpaRepository<Investimentos,Long> {
    Optional<List<Investimentos>> findByDataBetweenOrderByValor(LocalDate inicio,LocalDate fim);
}
