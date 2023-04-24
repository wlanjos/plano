package br.com.ekan.plano.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Long telefone;
    private LocalDate dtNascimento;
    private String dtInclusao;
    private String dtAtualizacao;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "beneficiario")
    private List<Documento> documentos;
}
