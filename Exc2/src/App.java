package Exc2.src;
public class App {
   /*  Escreva  uma  aplicação  que  cria  uma  instância  de  cadastro  de  funcionários  e  imprime  o 
    *  resultado de todas as consultas do exercício anterior.  */
    public static void main(String[] args) throws Exception {
        CadastroFuncionariosOriginal cad = new CadastroFuncionariosOriginal();
        System.out.println(cad);

        System.out.println("\nQuantidade de funcionarios com dependentes: " + cad.quantidadeFuncionariosComDependentes());
        System.out.println("\nSomatorio do salario bruto: " + cad.somatorioSalarioBruto());

        cad.aumentaSalarioInsalubres();

        System.out.println("\nNomes dos que tem matricula menor que 500: " + cad.nomesDosQueTemMatriculaMenorQue500());
        System.out.println("\nMedia salarial dos que nao tem insalubridade: " + cad.mediaSalarialDosQueNaoTemInsalubridade());
        System.out.println("\nFuncionarios com salario bruto maior que 5000: " + cad.getNomeMatriculaSalarioBrutoMaiorQueBase());

    }
}
