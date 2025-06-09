package Exc2.src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CadastroFuncionariosOriginal {
	private List<Funcionario> lstf;

	public CadastroFuncionariosOriginal() {
		lstf = new LinkedList<>();

		Random r = new Random();

		for (int i = 0; i < 40; i++) {
			int matricula = r.nextInt(1000) + 100;
			String nome = "Fulano" + i;
			boolean insalubridade = r.nextBoolean();
			int nroDep = r.nextInt(3) + 1;
			double salBase = (r.nextDouble() * 15000) + 500;
			Funcionario f = new Funcionario(matricula, nome, salBase, nroDep, insalubridade);
			lstf.add(f);
		}
	}

	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(lstf);
	}

	@Override
	public String toString() {
		return "CadastroFuncionarios [lstf=" + lstf + "]";
	}

	/* a) Retornar lista com otodos os funcionários que recebem insalubridades
	 *    e que tem dependentes. */
	
	public List<Funcionario> getInsalubridadeDependentes() {
		return lstf.stream()
		.filter(f -> (f.getInsalubridade() == true && f.getNroDependentes() > 0))
		.toList();
	}

	/* b) Retorna a quantidade de funcionáiros que tem dependentes. */
	public long quantidadeFuncionariosComDependentes() {
		return lstf.stream()
		.filter(f -> (f.getNroDependentes() > 0))
		.count();
	}

	/* c) Retorna o somatório do valor do salário bruto de todos os 
	 *    funcioniários que ganham mais de R$ 5.000,00. */
	public double somatorioSalarioBruto() {
		double somatorio = lstf.stream()
		.filter(f -> (f.getSalarioBruto() > 5000.00))
		.mapToDouble(Funcionario :: getSalarioBruto)
		.sum();
		return somatorio;
	}

	/* d) Aplica uma taxa de aumento em todos os funcionários que
	 *    recebem insalubridade. */
	public void aumentaSalarioInsalubres() {
	}

	/* e) Retorna uma lista de strings com nome e a matrícula de todos os
	 *    funcionários cujo salário bruto é 10% maior que o salário base. */
	public List<String> getNomeMatriculaSalarioBrutoMaiorQueBase() {
		return lstf.stream()
		.filter(f -> (f.getSalarioBruto() > f.getSalarioBase()))
		.map(Funcionario :: toString)
		.toList();
	}

	/* f) Retorna a média salarial dos funcionários que não recebem insalubridade. */
	public double mediaSalarialDosQueNaoTemInsalubridade() {
		double media = lstf.stream()
		.filter(f -> (f.getInsalubridade() == false))
		.mapToDouble(Funcionario :: getSalarioBase)
		.sum();
		return media / (media = lstf.stream().filter(f -> (f.getInsalubridade() == false)).count());
		
	}

	/* g) Retorna uma lista com o nome dos funcionários cujos números de matrícula
	 *    são menores que 500. */
	public List<String> nomesDosQueTemMatriculaMenorQue500() {
		List<String> nomes = new ArrayList<String>();
		nomes = lstf.stream()
		.filter(f -> (f.getMatricula() < 500))
		.map(Funcionario :: getNome)
		.toList();
		return nomes;
	}

	/* h) Retorna o salário líquido de um funcionário específico ou, -1 se o funcionário
	 *    não for encontrado. */
	public double getSalarioLiquido(int matricula) {
		double salarioLiquido = lstf.stream()
		.filter(f -> (f.getMatricula() == matricula))
		.mapToDouble(Funcionario :: getSalarioLiquido)
		.findFirst()
		.orElse(-1);
		return salarioLiquido;
		
	}
}
