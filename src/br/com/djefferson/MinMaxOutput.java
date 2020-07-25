package br.com.djefferson;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável pela formatação da saída dos dados.
 */
public class MinMaxOutput {

	private List<Integer> vNumbersUsed;
	private int sum;

	public MinMaxOutput(List<Integer> vNumbersUsed, int sum) {
		this.vNumbersUsed = vNumbersUsed;
		this.sum = sum;
	}

	@Override
	public String toString() {
		return vNumbersUsed.stream().map(e -> e.toString()).collect(Collectors.joining(" + ")) + " = " + sum;
	}

}