package com.henrique.manutencao.resources;

import com.henrique.manutencao.business.Retorno;
import com.henrique.manutencao.business.UsuarioBusiness;
import com.henrique.manutencao.domain.entities.Usuario;
import com.henrique.manutencao.domain.models.UsuarioModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    private UsuarioBusiness usuarioBusiness;

    @Autowired
    public UsuarioResource(UsuarioBusiness usuarioBusiness) {
        this.usuarioBusiness = usuarioBusiness;
    }

    @PostMapping(value="/login", consumes = "application/json", produces = "application/json")
    public Retorno<Usuario> logar(@RequestBody UsuarioModel usuario) {
        return usuarioBusiness.logar(usuario);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Retorno<Usuario> criar(@RequestBody UsuarioModel usuario) {
        return usuarioBusiness.criar(usuario);
    }
}
