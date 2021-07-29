package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatoriosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@EnableJpaRepositories
@SpringBootApplication // executar os comandos dessa classe ? | ler todas as aplicações em spring(@respository,...)
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatoriosService relatoriosService;

	private boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService,
								 CrudUnidadeTrabalhoService unidadeTrabalhoService,
								 CrudFuncionarioService funcionarioService,
								 RelatoriosService relatoriosService
								 ) {
		this.cargoService = cargoService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.funcionarioService = funcionarioService;
		this.relatoriosService = relatoriosService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args); //rodar a aplicação
	}

	@Override
	public void run(String... args) throws Exception{ //serve para rodar minha interface CargoRepository
		Scanner scanner = new Scanner(System.in);// separa os textos recebidos em blocos

		while(system){
			System.out.println("Qual função você deseja exexutar? ");
			System.out.println("0 - sair");
			System.out.println("1 - Cargo ");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatório");

			System.out.print("Opção: ");
			Integer funcion = scanner.nextInt();

			switch(funcion){
				case 0:
					system = false;
					break;

				case 1 :
					cargoService.inicial(scanner);
					break;

				case 2:
					funcionarioService.inicial(scanner);
					break;

				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;

				case 4:
					relatoriosService.inicial(scanner);
					break;

				default:
					break;
			}
		}
	}
}
