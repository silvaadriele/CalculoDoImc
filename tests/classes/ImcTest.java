package classes;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class ImcTest {
	static ArrayList <Pessoa> pessoas = new ArrayList<>();
	Menu menu = new Menu();
	Sistema sis = new Sistema();
	
	@Test 
	void adicionarNaListaTest() {
		Pessoa pessoa = new Pessoa("01B", "Adriele", 58, 166, 21, "f");
		assertEquals(pessoas.add(pessoa), pessoas.contains(pessoa));
	}
	
	@Test
	void calcularImcTest() {
		Pessoa pessoa = new Pessoa("01B", "Adriele", 58, 166, 21, "f");
		pessoas.add(pessoa);
		assertEquals(sis.retornaResultadoImc(0, pessoas),"[IMC calculado] IMC de Adriele: 21.04804761213529 correspondendo à categoria Peso ideal\n");
	}
	
	@Test
	void calcularPesoIdealTest() {
		Pessoa pessoa = new Pessoa("01B", "Adriele", 58, 166, 21, "f");
		pessoas.add(pessoa);
		assertEquals(sis.calcularPesoIdeal(0, pessoas), "[Peso ideal calculado] Peso ideal para Adriele: 62.0kg\n");
	}
	
	@Test
	void calcularGorduraCorporalTest() {
		Pessoa pessoa = new Pessoa("01B", "Adriele", 58, 166, 21, "f");
		pessoas.add(pessoa);
		assertEquals(sis.calcularGorduraCorporal(0, pessoas),"[Gordura corporal calculada] Gordura corporal de Adriele: 24.687657134562347%\n");
	}
	
}
