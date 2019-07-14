package com.henrique.manutencao.business;

import com.henrique.manutencao.domain.entities.Usuario;
import com.henrique.manutencao.domain.models.UsuarioModel;
import com.henrique.manutencao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioBusiness {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioBusiness(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private boolean validaSeUsuarioExiste(UsuarioModel usuario){
        return usuarioService.validaSeUsuarioExiste(usuario);
    }

    public Retorno<Usuario> logar(UsuarioModel usuario){
        boolean login = usuarioService.logar(usuario);
        if (!login){
            return  new Retorno<>(false,"Email ou senha errados!",null);
        }

        return new Retorno<>(true,"Logado com sucesso!", usuarioService.getDadosUsuario(usuario));
    }
    public Retorno<Usuario> criar(UsuarioModel usuario) {
        boolean usuarioExiste = validaSeUsuarioExiste(usuario);
        if (usuarioExiste){
            return new Retorno<>(false,"Usuario ja existe!!!",null);
        }
        return new Retorno<>(true,"Usuario criado com sucesso!",usuarioService.criar(usuario));
    }
}
