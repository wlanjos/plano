package br.com.ekan.plano.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BeneficiarioRequest {

    @NotBlank(message = "Nome não pode ser vazio ou nulo")
    private String nome;
    @NotBlank(message = "Data de Nascimento não pode ser vazio ou nulo")
    private LocalDate dataNascimento;
    @NonNull()
    private Long telefone;
}
