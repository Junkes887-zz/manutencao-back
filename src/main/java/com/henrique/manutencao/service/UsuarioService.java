package com.henrique.manutencao.service;

import com.henrique.manutencao.domain.entities.Usuario;
import com.henrique.manutencao.domain.models.UsuarioModel;
import com.henrique.manutencao.repository.UsuarioRepository;

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

    private Usuario converterEmEntidade(UsuarioModel model) {
        Usuario usuario = new Usuario();
        usuario.setId(null);
        usuario.setNome(model.getNome());
        usuario.setEmail(model.getEmail());
        usuario.setSenha(model.getSenha());
        return usuario;
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

    public boolean validaSeUsuarioExiste(UsuarioModel model){
        return usuarioRepository.existsByNomeAndEmail(model.getNome(),model.getEmail());
    }
}