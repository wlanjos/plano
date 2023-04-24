package br.com.ekan.plano.model.dto;

import br.com.ekan.plano.entity.Documento;
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
public class BeneficiarioDocumentoDTO {

    private long id;
    private String nome;
    private Long telefone;
    private String dtNascimento;
    private String dtInclusao;
    private LocalDate dtAtualizacao;
    private List<Documento> documentos;

}
