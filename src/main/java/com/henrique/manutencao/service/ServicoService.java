package com.henrique.manutencao.service;

import com.henrique.manutencao.domain.entities.Servico;
import com.henrique.manutencao.domain.models.ServicoModel;
import com.henrique.manutencao.repository.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    private Servico converterEmEntidade(ServicoModel model){
        Servico servico = new Servico();
        servico.setId(null);
        servico.setDescricao(model.getDescricao());
        servico.setValor(model.getValor());
        return servico;
    }


    public Servico criar(ServicoModel model) {
        Servico servico = converterEmEntidade(model);
        return servicoRepository.save(servico);
    }
}
