package com.eli.eli_food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eli.eli_food.domain.exception.EntidadeEmUsoException;
import com.eli.eli_food.domain.exception.EntidadeNaoEncontradaException;
import com.eli.eli_food.domain.model.Cozinha;
import com.eli.eli_food.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	
	public void excluir(Long id) {
		try {
			cozinhaRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new  EntidadeNaoEncontradaException (String.format("Não existe um cadastro de cozinha com o código %d.", id));
		} catch(DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Cozinha de código %d não pode ser removida pois está em uso", id));
		}
		
	}
	
}
