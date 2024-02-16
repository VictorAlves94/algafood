package com.victoralves.algafood.service;

import com.victoralves.algafood.domain.exception.EntidadeEmUsoException;
import com.victoralves.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.model.Estado;
import com.victoralves.algafood.domain.repository.CidadeRepository;
import com.victoralves.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;
    public Cidade salvar(Cidade cidade) {
        Long estado_id = cidade.getEstado().getId();
        Estado estado = estadoRepository.findById(estado_id);

        if (estado == null){
            throw new EntidadeNaoEncontradaException(
                    String.format("o Estado de código %d não existe no banco de dados", estado_id)
            );
        }
        cidade.setEstado(estado);
        return cidadeRepository.save(cidade);
    }

    public void excluir(Long id) {
        try{
            cidadeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe Cidade cadastrada com o código %d", id)
            );
        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Essa Cidade Não Pode ser removida, pois está em uso.",id)
            );
        }
    }
}
