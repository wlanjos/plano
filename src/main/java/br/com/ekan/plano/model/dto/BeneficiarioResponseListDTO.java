package br.com.ekan.plano.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class BeneficiarioResponseListDTO {

    private long id;
    private String nome;
    private Long telefone;
    private String dtNascimento;
    private String dtInclusao;
    private LocalDate dtAtualizacao;
    private List<DocumentoResponseDTO> documentos;


}
