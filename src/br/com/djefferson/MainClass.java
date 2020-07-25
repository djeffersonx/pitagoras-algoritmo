package br.com.djefferson;

/*

Organização do projeto:

	MainClass: Representa uma classe cliente do MainMaxSumManager.
	MinMaxSumAlgorithm:  Classe responsável por processar o algoritmo.
	MinMaxOutput: Classe responsável por formatar e realizar a saída dos dados

*/
public class MainClass {

	public static void main(String[] args) {

		MinMaxSumAlgorithm minMaxSumAlgorithm = new MinMaxSumAlgorithm(new Integer[] { 5, -3, 7, 8, 2 });

		System.out.println(minMaxSumAlgorithm.getMinSum());
		System.out.println(minMaxSumAlgorithm.getMaxSum());

	}

}