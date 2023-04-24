package br.com.ekan.plano.service;

import br.com.ekan.plano.entity.Usuario;
import br.com.ekan.plano.model.dto.login.Login;
import br.com.ekan.plano.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public ResponseEntity login(Login request) {

        Usuario usuario = Usuario.builder()
                .login(request.getLogin())
                .password(request.getPassword())
                .build();

        repository.save(usuario);

        return new ResponseEntity("", HttpStatus.CREATED);

    }
}
