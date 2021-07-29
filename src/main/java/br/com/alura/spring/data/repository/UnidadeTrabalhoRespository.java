package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadeTrabalhoRespository extends CrudRepository<UnidadeTrabalho, Integer> {
}
