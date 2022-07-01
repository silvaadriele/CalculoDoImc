package classes;
import java.util.ArrayList;

public class Sistema {
	
	public String retornaResultadoImc(int index, ArrayList<Pessoa> pessoas) {
		
		verificaPosicaoDaLista(index, pessoas);
		
		Pessoa pessoa = pessoas.get(index);
		double imc = calcularImc(pessoa);
		pessoa.setImc(imc);
		avaliaCategoriaComBaseNoImc(pessoa);
		return "[IMC calculado] IMC de "+pessoa.getNome()+": "+pessoa.getImc()+" correspondendo à categoria "+pessoa.getCategoria()+"\n";	
		
	}


	private void verificaPosicaoDaLista(int index, ArrayList<Pessoa> pessoas) {
		if(index>=pessoas.size()) {
			throw new RuntimeException("Posição não encontrada\n");
		}
	}


	private void avaliaCategoriaComBaseNoImc(Pessoa pessoa) {
		if(pessoa.getSexo().toLowerCase().equals("m")) {
			avaliaCategoriaMasculina(pessoa);
		}
		else if (pessoa.getSexo().toLowerCase().equals("f")) {
			avaliaCategoriaFeminina(pessoa);
		}
	}


	private void avaliaCategoriaFeminina(Pessoa pessoa) {
		if (pessoa.getImc()<19.1) {
			pessoa.setCategoria("Abaixo do peso");
		}
		else if(pessoa.getImc()<=25.8) {
			pessoa.setCategoria("Peso ideal");

		}
		else {
			pessoa.setCategoria("Acima do peso");
		}
	}


	private void avaliaCategoriaMasculina(Pessoa pessoa) {
		if(pessoa.getImc()<20.7) {
			pessoa.setCategoria("Abaixo do peso");
		}
		else if (pessoa.getImc()<=26.4) {
			pessoa.setCategoria("Peso ideal");
		}
		else {
			pessoa.setCategoria("Acima do peso");
		}
	}


	private double calcularImc(Pessoa pessoa) {
		return pessoa.getPeso()/((pessoa.getAltura()*pessoa.getAltura()/10000));
	}
	
	
	public String calcularPesoIdeal(int index, ArrayList <Pessoa> pessoas) {
		verificaPosicaoDaLista(index, pessoas);
		
		Pessoa a = pessoas.get(index);
		double pesoIdeal;
		if(a.getSexo().toLowerCase()=="m") {
			pesoIdeal = (a.getAltura()-100)-((a.getAltura()-150)/2);
			a.setPesoIdeal(pesoIdeal);
		}
		else {
			pesoIdeal = (a.getAltura()-100)-((a.getAltura()-150)/4);
			a.setPesoIdeal(pesoIdeal);
		}
		return "[Peso ideal calculado] Peso ideal para "+a.getNome()+": "+a.getPesoIdeal()+"kg\n";
		
	}
	
	
	public String calcularGorduraCorporal(int index1, ArrayList <Pessoa> pessoas) {
		Pessoa a = pessoas.get(index1);
		if(index1>=pessoas.size()) {
			throw new RuntimeException("Posição não encontrada\n");
		}
		else if (a.getImc()==0) {
			throw new RuntimeException("O IMC deve ser calculado antes da Gordura Corporal\n");
		}
		else {
			double gorduraCorporal;
			if(a.getSexo().toLowerCase()=="m") {
				gorduraCorporal = (1.2 * a.getImc()) - 10.8 + (0.23 * a.getIdade()) - 5.4;
				a.setGorduraCorporal(gorduraCorporal);
			}
			else {
				gorduraCorporal = (1.2*a.getImc()) + (0.23*a.getIdade() - 5.4);
				a.setGorduraCorporal(gorduraCorporal);
			}
			return "[Gordura corporal calculada] Gordura corporal de "+a.getNome()+": "+a.getGorduraCorporal()+"%\n";
		}
		
	}
	
}
