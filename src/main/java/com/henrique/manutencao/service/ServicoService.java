package com.henrique.manutencao.service;

import com.henrique.manutencao.domain.entities.Servico;
import com.henrique.manutencao.domain.models.ServicoModel;
import com.henrique.manutencao.repository.ServicoRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
        servico.setId(model.getId() != null ? model.getId() : null);
        servico.setDescricao(model.getDescricao());
        servico.setValor(model.getValor());
        servico.setData_ini(model.getData_ini());
        servico.setData_fim(model.getData_fim());
        servico.setStatus(model.getStatus());
        servico.setCliente(model.getCliente());
        servico.setId_cliente(model.getId_cliente());
        servico.setId_responsavel(model.getId_responsavel());
        servico.setResponsavel(model.getResponsavel());
        servico.setPrioridade(model.getPrioridade());
        servico.setMarca(model.getMarca());
        servico.setTipo(model.getTipo());
        servico.setObservacao(model.getObservacao());
        return servico;
    }

    public Servico criar(ServicoModel model) {
        Servico servico = converterEmEntidade(model);
        return servicoRepository.save(servico);
    }

    public Servico editar(ServicoModel model){
        Servico servico = converterEmEntidade(model);
        return servicoRepository.save(servico);
    }

    public List<Servico> findAll(){
        return servicoRepository.findAll();
    }
}
