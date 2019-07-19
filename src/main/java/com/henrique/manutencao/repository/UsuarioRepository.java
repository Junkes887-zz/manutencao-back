package com.henrique.manutencao.repository;

import com.henrique.manutencao.domain.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario getFirstByNome(String nome);
    boolean existsByNomeAndEmail(String nome, String email);
    boolean existsByEmailAndSenha(String email, String senha);
    Usuario getFirstByEmailAndSenha(String email, String senha);
}
