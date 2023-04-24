package br.com.ekan.plano.model.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Login {

    private String login;
    private String password;
}

