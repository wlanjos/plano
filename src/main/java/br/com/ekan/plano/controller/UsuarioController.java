package br.com.ekan.plano.controller;

import br.com.ekan.plano.entity.Usuario;
import br.com.ekan.plano.model.dto.login.Login;
import br.com.ekan.plano.service.TokenService;
import br.com.ekan.plano.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;

    @PostMapping("/create")
    @ApiOperation(value = "Cadastrar novo usuario na base")
    public ResponseEntity createUser(@RequestBody Login login) {
        login.setPassword(encoder.encode(login.getPassword()));
        return service.login(login);
    }

    @PostMapping("/login")
    @ApiOperation(value = "Realizar Login na aplicação")
    public String login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.getLogin() ,login.getPassword());

        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) authenticate.getPrincipal();

        return tokenService.gerarToken(usuario);

    }

}
