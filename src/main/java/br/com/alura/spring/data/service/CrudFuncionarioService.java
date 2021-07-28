package br.com.alura.spring.data.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudFuncionarioService {

    private boolean system = true;

    private final CrudFuncionarioService funcionarioService;

    public CrudFuncionarioService(CrudFuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;

    }

    public void inicial(Scanner scanner){
        while (system){
            System.out.println("");
            System.out.println("Qual ação de funcionário você quer executar? ");
            System.out.println("0 - sair");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    system = false;
                    break;

                case 1:
                    funcionarioService.adicionar(scanner);
                    break;

                case 2:
                    funcionarioService.atualizar(scanner);
                    break;

                case 3:
                    funcionarioService.visualizar(scanner);
                    break;

                case 4:
                    funcionarioService.deletar(scanner);
                    break;

                default:
                    break;
            }
        }
    }

    public void adicionar(Scanner scanner){
        System.out.print("Função do novo funcionário: ");
        String novoFuncionario = scanner.next();

        //Funcionario funcionario = new Funcionario();

    }

    public void atualizar(Scanner scanner){

    }

    public void visualizar(Scanner scanner){

    }

    public void deletar(Scanner scanner){

    }


}
