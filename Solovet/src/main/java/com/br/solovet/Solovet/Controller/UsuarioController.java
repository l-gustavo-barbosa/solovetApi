package com.br.solovet.Solovet.Controller;

import com.br.solovet.Solovet.Infra.Secutiry.DadosTokenJWT;
import com.br.solovet.Solovet.Infra.Secutiry.TokenService;
import com.br.solovet.Solovet.Model.Usuario.DadosCadastro;
import com.br.solovet.Solovet.Model.Usuario.Usuario;
import com.br.solovet.Solovet.Model.Usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;


    public UsuarioController() {
    }

    @Transactional
    @PostMapping("/cadastro")
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastro dados){
        var usuario = new Usuario(dados);
        System.out.println(usuario.getPassword());
        usuario.setPassword(passwordEncoder.encode(dados.password()));
        System.out.println(usuario.getPassword());
        repository.save(usuario);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DadosCadastro dados){

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.username(), dados.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @Autowired
    public PasswordEncoder passwordEncoder;

}



