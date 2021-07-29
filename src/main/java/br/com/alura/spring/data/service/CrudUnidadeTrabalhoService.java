package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRespository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private Boolean system = true;
    private final UnidadeTrabalhoRespository unidadeTrabalhoRespository;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRespository unidadeTrabalhoRespository){
        this.unidadeTrabalhoRespository = unidadeTrabalhoRespository;
    }

    public void inicial(Scanner scanner){
        System.out.println("Qual acao de unidade deseja executar");
        System.out.println("0 - Sair");
        System.out.println("1 - Salvar");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Visualizar");
        System.out.println("4 - Deletar");

        System.out.print("Opção: ");
        int action = scanner.nextInt();
        switch (action) {
            case 0:
                system = false;
                break;
            case 1:
                salvar(scanner);
                break;
            case 2:
                atualizar(scanner);
                break;
            case 3:
                visualizar();
                break;
            case 4:
                deletar(scanner);
                break;
            default:
                system = false;
                break;
        }
    }

    private void deletar(Scanner scanner) {
        System.out.print("Id: ");
        Integer id = scanner.nextInt();
        unidadeTrabalhoRespository.deleteById(id);
        System.out.println("Id: " + id + " Deletado!!!");
    }

    private void visualizar() {
        Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRespository.findAll();
        unidades.forEach(unidade -> System.out.println(unidade));
    }

    private void atualizar(Scanner scanner) {
        System.out.print("Digite o id: ");
        Integer id = scanner.nextInt();

        System.out.print("Digite o nome da unidade: ");
        String nome = scanner.next();

        System.out.print("Digite o endereço: ");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setEndereco(endereco);
        unidadeTrabalho.setDescricao(nome);
    }

    private void salvar(Scanner scanner) {
        System.out.print("Digite o nome da unidade: ");
        String nome = scanner.next();

        System.out.print("Digite o endereço:");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(nome);
        unidadeTrabalho.setEndereco(endereco);
    }

}
