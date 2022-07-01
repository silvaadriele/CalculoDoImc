package classes;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
	private int opcao;
	static ArrayList<Pessoa> pessoas = new ArrayList<>();
	private Scanner scanner1;
	private Scanner scanner2;
	private Scanner scanner3;
	private Scanner scanner4;
	private Scanner scanner5;
	private Scanner scanner6;
	private Scanner scanner7;
	private Scanner s;

	public void imprimirMenu() {
		Sistema sis = new Sistema();
		scanner1 = new Scanner(System.in);
		scanner2 = new Scanner(System.in);
		scanner3 = new Scanner(System.in);
		scanner4 = new Scanner(System.in);
		scanner5 = new Scanner(System.in);
		scanner6 = new Scanner(System.in);
		scanner7 = new Scanner(System.in);
		s = new Scanner(System.in);
		boolean parar = false;

		while (parar == false) {
			System.out.println("Digite a opção desejada:\n[1]Inserir Pessoa\n[2]calcularIMC"
					+ "\n[3]CalcularPesoIdeal\n[4]Calcular taxa de gordura corporal\n[5]Imprimir lista de pessoas\n[6]Sair\n ");
			opcao = scanner1.nextInt();
			if (opcao == 1) {
				inserePessoa();
			}

			else if (opcao == 2) {
				calcularImc(sis);
			}

			else if (opcao == 3) {
				calcularPesoIdeal(sis);
			}

			else if (opcao == 4) {
				calcularGorduraCorporal(sis);
			}

			else if (opcao == 5) {
				imprimirLista(pessoas);
			}

			else if (opcao == 6) { // sair
				System.out.println("Finalizando programa, até a próxima!");
				parar = true;
			}

			else { // opcao inválida
				System.out.println("Opção inválida\n");
			}

		}
	}

	private void calcularGorduraCorporal(Sistema sis) {
		System.out.println("Digite a posição da pessoa para calcular a taxa de gordura corporal: ");
		int index2 = s.nextInt();
		try {
			System.out.println(sis.calcularGorduraCorporal(index2 - 1, pessoas));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void calcularPesoIdeal(Sistema sis) {
		System.out.println("Digite a posição da pessoa para calcular o peso ideal: ");
		int index1 = s.nextInt();
		try {
			System.out.println(sis.calcularPesoIdeal(index1 - 1, pessoas));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void calcularImc(Sistema sis) {
		System.out.println("Digite a posição da pessoa para calcular o IMC: ");
		int index = s.nextInt();
		try {
			System.out.println(sis.retornaResultadoImc(index - 1, pessoas));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	private void inserePessoa() {
		System.out.println("INSERIR PESSOA:\nDigite as seguintes informações:\nCódigo: ");
		String codigo = scanner2.nextLine();

		System.out.println("Nome: ");
		String nome = scanner3.nextLine();

		System.out.println("Peso(kg): ");
		double peso = scanner4.nextDouble();

		System.out.println("Altura(cm): ");
		double altura = scanner5.nextDouble();

		System.out.println("Idade: ");
		int idade = scanner6.nextInt();

		System.out.println("Sexo(F para feminino e M para masculino): ");
		String sexo = scanner7.nextLine();

		try {
			Pessoa a = new Pessoa(codigo, nome, peso, altura, idade, sexo);
			pessoas.add(a);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	protected void imprimirLista(ArrayList<Pessoa> pessoas) {
		for (Pessoa pessoa : pessoas) {
			imprimeDadosDa(pessoa);
			imprimeInformacoesDa(pessoa);

		}
	}

	protected void imprimeInformacoesDa(Pessoa pessoa) {
		String descricao;
		descricao= (pessoa.getImc() == 0) ? " || IMC: não definido || Categoria: não definido"
				: String.format(" || IMC: %.1f || Categoria: %s", pessoa.getImc(), pessoa.getCategoria());

		descricao += (pessoa.getPesoIdeal() == 0) ? " || Peso ideal: não definido "
				: String.format(" || Peso ideal: %.1f", pessoa.getPesoIdeal());
		
		descricao += (pessoa.getGorduraCorporal() == 0) ? " || Gordura corporal: não definido"
				: String.format(" || Gordura corporal: %.1f", pessoa.getGorduraCorporal());

		System.out.println(descricao);
	}

	protected void imprimeDadosDa(Pessoa pessoa) {
		System.out.print("Código: " + pessoa.getCodigo() + " || Nome: " + pessoa.getNome() + " || " + "Peso: "
				+ pessoa.getPeso() + " || Altura: " + pessoa.getAltura() + " || " + "Idade: " + pessoa.getIdade()
				+ " || Sexo: " + pessoa.getSexo());
	}
}