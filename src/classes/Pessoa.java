package classes;

public class Pessoa {
	private String codigo, nome, categoria, sexo; 
	private double peso, altura, imc, pesoIdeal, gorduraCorporal;
	private int idade;
	
	
	public Pessoa(String codigo, String nome, double peso, double altura, int idade, String sexo) {

		if (peso<=0 || altura<=0 || idade<=0){
			throw new RuntimeException("Dados inválidos");
		}
		if (!sexo.toLowerCase().equals("f") && !sexo.toLowerCase().equals("m")) {
			throw new RuntimeException("Dados inválidos(sexo)");
		}
		this.codigo=codigo;
		this.nome=nome;
		this.peso=peso;
		this.altura=altura;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	
	public double getGorduraCorporal() {
		return gorduraCorporal;
	}


	public void setGorduraCorporal(double gorduraCorporal) {
		this.gorduraCorporal = gorduraCorporal;
	}


	public double getPesoIdeal() {
		return pesoIdeal;
	}


	public void setPesoIdeal(double pesoIdeal) {
		this.pesoIdeal = pesoIdeal;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
}
