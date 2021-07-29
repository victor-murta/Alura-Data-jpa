package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private Boolean system = true;

    private final FuncionarioRepository funcionarioRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatoriosService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        System.out.println("Qual acao de unidade deseja executar");
        System.out.println("0 - Sair");
        System.out.println("1 - Busca Funcionário por nome");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Data contratação");

        System.out.print("Opção: ");
        int action = scanner.nextInt();
        switch (action) {
            case 0:
                system = false;
                break;
            case 1:
                buscaFuncionarioNome(scanner);
                break;

            case 2:
                buscaNomeSalarioMaiorDataContratacao(scanner);
                break;

            case 3:
                buscaFuncionarioDataContratacaoMaior(scanner);
                break;

            default:
                system = false;
                break;
        }
    }

    private void buscaFuncionarioNome(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        List<Funcionario> list = funcionarioRepository.findByNome(nome);

        list.forEach(System.out::println);
    }

    private void buscaNomeSalarioMaiorDataContratacao(Scanner scanner){
        System.out.print("Nome: ");
        String nome = scanner.next();

        System.out.print("Data: ");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.print("Salário: ");
        Double salario = scanner.nextDouble();

        List<Funcionario> list = funcionarioRepository
                .findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
    }

    private void buscaFuncionarioDataContratacaoMaior(Scanner scanner){
        System.out.print("Data: ");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> list = funcionarioRepository
                .findDataContratacaoMaior(localDate);

    }

}
