package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import br.com.alura.spring.data.orm.FuncionarioProjecao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> { //fazendo paginação
    // <manipular a classe Funcionario , tipo do id
    List<Funcionario> findByNome(String nome);

    //Criando Query (JPQL)
    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome "
            + "AND f.salario >= :salario AND f.dataContratacao = :data")
    List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);

    //native query
    @Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data",
            nativeQuery = true)
    List<Funcionario> findDataContratacaoMaior(LocalDate data);

    @Query(value = "SELECT f.id, f.nome, f.salario FROM Funcionario f", nativeQuery = true)
    List<FuncionarioProjecao> fidnFuncionarioSalario();

}
