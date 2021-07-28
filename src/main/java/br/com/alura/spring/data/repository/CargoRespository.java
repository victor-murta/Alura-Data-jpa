package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRespository extends CrudRepository<Cargo, Integer> { // acessar o repositório de Crud do spring
    // <manipular/ trabalhar com a classe Cargo , tipo do id>

}
