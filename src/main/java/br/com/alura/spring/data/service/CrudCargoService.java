package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRespository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private Boolean system = true;
    //Service serve para inserir os dados no banco de dados | service chama a controler
    private final CargoRespository cargoRespository;

    public CrudCargoService(CargoRespository cargoRespository){
        this.cargoRespository = cargoRespository;
    }

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("");
            System.out.println("Qual ação de cargo você quer executar? ");
            System.out.println("0 - sair");
            System.out.println("1 - Cargo");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");
            System.out.print("Opção: ");
            int action = scanner.nextInt();
            switch(action){
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
                    visualizar(scanner);
                    break;

                case 4:
                    deletar(scanner);
                    break;

                default:
                    system = false;
                    break;
            }
        }
        salvar(scanner);
    }

    private void salvar(Scanner scanner){
        System.out.print("Descrição do cargo: ");
        String descricao = scanner.next(); // receber o valor inserido pelo usuário

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRespository.save(cargo);
        System.out.println("Salvo!");
    }

    private void atualizar(Scanner scanner){
        System.out.print("Id: ");
        int id = scanner.nextInt();

        System.out.print("Nova descrição do cargo: ");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);
        cargoRespository.save(cargo);
    }

    public void visualizar(Scanner scanner){
       Iterable<Cargo> cargos = cargoRespository.findAll();
       cargos.forEach(cargo -> {
           System.out.println(cargo);
       });
    }

    public void deletar(Scanner scanner){
        System.out.print("Id: ");
        cargoRespository.deleteById(scanner.nextInt()); //delete by id devolve um Optional (sabe se o objeto exite ou não)
        System.out.println("Deletado com sucesso!");

    }
}
