package classes;
import java.util.ArrayList;

public class SistemaIMCTeste {
	static ArrayList <Pessoa> pessoas = new ArrayList<>();
	
	public static void main (String[] args) {
		Menu menu = new Menu();
		
		pessoas.add(new Pessoa ("01B", "Adriele", 58, 166, 21, "f"));
		
		pessoas.add(new Pessoa ("22X", "João", 70, 178, 30, "m"));
		
		pessoas.add(new Pessoa ("44A", "Manuela", 50, 171, 23, "f"));
		
		pessoas.add(new Pessoa ("15G", "Amanda", 80, 162, 18, "f"));
		
		pessoas.add(new Pessoa ("56R", "Gabriel", 105, 168, 40, "m"));
		menu.pessoas = pessoas;
		menu.imprimirMenu();
		
	}
}
