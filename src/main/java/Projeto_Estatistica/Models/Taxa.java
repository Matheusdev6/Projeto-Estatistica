package Projeto_Estatistica.Models;


import jakarta.persistence.*;
import lombok.Getter;
import java.util.Date;

@Getter
@Entity
@Table(name = "taxa_selic")
public class Taxa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data",nullable = false)
    private Date data;

    @Column(name = "valor",nullable = false)
    private Double valor;

    protected Taxa() {
    }
}
