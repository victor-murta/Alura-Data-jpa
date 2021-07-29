package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.CargoRespository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRespository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class CrudFuncionarioService {

    private boolean system = true;

    private final CargoRespository cargoRespository;
    private final FuncionarioRepository funcionarioRepository;
    private final UnidadeTrabalhoRespository unidadeTrabalhoRespository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public CrudFuncionarioService(CrudFuncionarioService funcionarioService,
                                  FuncionarioRepository funcionarioRepository,
                                  UnidadeTrabalhoRespository unidadeTrabalhoRespository,
                                  CargoRespository cargoRespository){
        this.funcionarioRepository = funcionarioRepository;
        this.unidadeTrabalhoRespository = unidadeTrabalhoRespository;
        this.cargoRespository = cargoRespository;
    }

    public void inicial(Scanner scanner){
        while (system){
            System.out.println("Qual ação de funcionário você quer executar? ");
            System.out.println("0 - sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("3 - Deletar");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            switch (opcao) {
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
                    break;
            }
        }
    }

    private void salvar(Scanner scanner){
        System.out.print("Função do novo funcionário: ");
        String novoFuncionario = scanner.next();

        System.out.print("Cpf: ");
        String cpf = scanner.next();

        System.out.print("CargoId: ");
        Integer cargo = scanner.nextInt();

        System.out.print("Unidade de trabalho: ");
        List<UnidadeTrabalho> unidadeDeTrabalho = unidade(scanner);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(novoFuncionario);
        funcionario.setCpf(cpf);
        funcionario.setUnidadeTrabalhos(unidadeDeTrabalho);
        funcionarioRepository.save(funcionario);
        System.out.println("Funcionário: " + funcionario + " Salvo");

    }

    private void atualizar(Scanner scanner) {
        System.out.println("Digite o id");
        Integer id = scanner.nextInt();

        System.out.println("Digite o nome");
        String nome = scanner.next();

        System.out.println("Digite o cpf");
        String cpf = scanner.next();

        System.out.println("Digite o salario");
        Double salario = scanner.nextDouble();

        System.out.println("Digite a data de contracao");
        String dataContratacao = scanner.next();

        System.out.println("Digite o cargoId");
        Integer cargoId = scanner.nextInt();

        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));
        Optional<Cargo> cargo = cargoRespository.findById(cargoId);
        funcionario.setCargo(cargo.get());

        funcionarioRepository.save(funcionario);
        System.out.println("Alterado");
    }


    private List<UnidadeTrabalho> unidade(Scanner scanner){
        Boolean isTrue = true;
        List<UnidadeTrabalho> unidades = new ArrayList<>();

        while(isTrue){
            System.out.println("Digite a unidadeId (0 para sair)");
            Integer unidadeId = scanner.nextInt();

            if(unidadeId != 0){
                Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRespository.findById(unidadeId);
            }else{
                isTrue = false;
            }
        }
        return unidades;
    }

    private void visualizar(Scanner scanner){
        System.out.print("Qual página você deseja visualizar? ");
        Integer page = scanner.nextInt();

        Pageable pageable = PageRequest.of(page, 5, Sort.unsorted());
        Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
        System.out.println("Total de elementos: " + funcionarios.getTotalElements());
        System.out.println("Página " + funcionarios.getNumber() + " de " + funcionarios);
        funcionarios.forEach( funcionario -> System.out.println(funcionario));
    }

    private void deletar(Scanner scanner){
        System.out.print("Id: ");
        Integer id = scanner.nextInt();
        funcionarioRepository.deleteById(id);
        System.out.println("Id: " + id + " Deletado!!!");

    }


}
