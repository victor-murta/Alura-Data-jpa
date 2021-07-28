package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRespository;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication // executar os comandos dessa classe ? | ler todas as aplicações em spring(@respository,...)
public class SpringDataApplication implements CommandLineRunner {

	//private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;

	private boolean system = true;

	/*public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}*/

	public SpringDataApplication(CrudFuncionarioService funcionarioService){
		this.funcionarioService = funcionarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args); //rodar a aplicação
	}

	@Override
	public void run(String... args) throws Exception{ //serve para rodar minha interface CargoRepository
		Scanner scanner = new Scanner(System.in);// separa os textos recebidos em blocos

		while(system){
			//cargoService.inicial(scanner);
			funcionarioService.inicial(scanner);
		}
	}
}
