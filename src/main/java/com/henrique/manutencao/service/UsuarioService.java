package com.henrique.manutencao.service;

import com.henrique.manutencao.domain.PermissaoEnum;
import com.henrique.manutencao.domain.entities.Usuario;
import com.henrique.manutencao.domain.models.UsuarioModel;
import com.henrique.manutencao.repository.UsuarioRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario converterEmEntidade(UsuarioModel model) {
        Usuario usuario = new Usuario();
        usuario.setId(model.getId() != null ? model.getId() : null);
        usuario.setNome(model.getNome());
        usuario.setEmail(model.getEmail());
        usuario.setSenha(model.getSenha());
        usuario.setPermissao(PermissaoEnum.valueOf(PermissaoEnum.class, model.getPermissao()));
        return usuario;
    }

    public UsuarioModel converterEmModel(Usuario usuario) {
        UsuarioModel model = new UsuarioModel();
        model.setId(usuario.getId() != null ? usuario.getId() : null);
        model.setNome(usuario.getNome());
        model.setEmail(usuario.getEmail());
        model.setSenha(usuario.getSenha());
        model.setPermissao(usuario.getPermissao().name());
        return model;
    }

    public boolean logar(UsuarioModel model) {
        return usuarioRepository.existsByEmailAndSenha(model.getEmail(),model.getSenha());
    }

    public Usuario getDadosUsuario(UsuarioModel model) {
        return usuarioRepository.getFirstByEmailAndSenha(model.getEmail(),model.getSenha());
    }

    public Usuario criar(UsuarioModel model) {
        Usuario usuario = converterEmEntidade(model);
        return usuarioRepository.save(usuario);
    }

    public Usuario editar(UsuarioModel model) {
        Usuario usuario = converterEmEntidade(model);
        return usuarioRepository.save(usuario);
    }

    public boolean validaSeUsuarioExiste(UsuarioModel model){
        return usuarioRepository.existsByNomeOrEmail(model.getNome(),model.getEmail());
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
}