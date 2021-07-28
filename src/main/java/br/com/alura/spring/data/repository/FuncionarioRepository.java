package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Cargo, Integer> {
    // <manipular a classe Cargo , tipo do id
}
