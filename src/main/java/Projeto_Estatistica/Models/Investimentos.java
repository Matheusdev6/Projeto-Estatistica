package Projeto_Estatistica.Models;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@Table(name = "investimento_direto")
public class Investimentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data",nullable = false)
    private Date data;

    @Column(name = "valor",nullable = false)
    private Double valor;

    protected Investimentos() {
    }
}
