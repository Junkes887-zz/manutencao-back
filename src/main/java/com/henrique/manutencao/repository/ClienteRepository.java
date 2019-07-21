package com.henrique.manutencao.repository;

import com.henrique.manutencao.domain.entities.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

    boolean existsByNomeOrEmailOrTelefone(String nome, String email, Long Telefone);
}
