package br.com.ekan.plano.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BeneficiarioDTO {

    private long id;
    private String nome;
    private Long telefone;
    private String dtNascimento;
    private String dtInclusao;
    private String dtAtualizacao;

}
