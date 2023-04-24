package br.com.ekan.plano.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DocumentoResponseDTO {

    private long id;
    private String tipoDocumento;
    private String descricao;
    private String dataInclusa;
    private String dataAtualização;
}
