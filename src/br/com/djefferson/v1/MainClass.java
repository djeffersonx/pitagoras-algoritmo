package br.com.djefferson.v1;

public class MainClass {

	public static void main(String[] args) {

		MinMaxSumAlgorithm minMaxSumAlgorithm = new MinMaxSumAlgorithm(new Integer[] { 4, -3, 7, 8, 2 });

		System.out.println(minMaxSumAlgorithm.getMinSum());
		System.out.println(minMaxSumAlgorithm.getMaxSum());

	}

}
