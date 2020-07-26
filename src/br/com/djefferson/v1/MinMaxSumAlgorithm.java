package br.com.djefferson.v1;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Classe responśavel por gerenciar as entradas de dados e realizar o
 * processamento das regras.
 */
public class MinMaxSumAlgorithm {

	// Utilizei o nome 'v' na variável para manter o nome
	// utilizado na especificação do problema.
	private List<Integer> v;

	// Mais fácil se ler o número assim, não precisamos ficar contando os zeros pra
	// descobrir q número é.
	private static final int ONE_BILLION = 1000000000;

	// Negativando _ONE_BILLION
	private static final int V_MIN_VALUE = ~ONE_BILLION;

	// Valor positivo de ONE_BILLION
	private static final int V_MAX_VALUE = ONE_BILLION;

	// Construtor recebe entrada necessária e já realiza validações rejeitando se
	// necessário.
	public MinMaxSumAlgorithm(Integer[] vInput) {

		if (vInput == null) {
			throw new InvalidParameterException("Valor de V é obrigatório");
		}

		v = Arrays.asList(vInput);

		if (!isValidArraySizeOfN()) {
			throw new InvalidParameterException("Valor de N inválido, entre com um valor entre 2 e 10");
		}

		if (!isValidInputOfV()) {
			throw new InvalidParameterException(
					"Valor de V inválido, entre com um valor entre " + V_MIN_VALUE + " e " + V_MAX_VALUE + "");
		}

		// deixo os valores já ordenados na construção.
		v.sort(Comparator.naturalOrder());
	}

	private boolean isValidInputOfV() {
		return !v.stream().filter(e -> !(e > V_MIN_VALUE && e < V_MAX_VALUE)).findAny().isPresent();
	}

	private boolean isValidArraySizeOfN() {
		int vSize = v.size();
		return (vSize > 2 && vSize < 10);
	}

	public MinMaxOutput getMinSum() {
		List<Integer> listToGetMin = v.subList(0, v.size() - 1);
		return new MinMaxOutput(listToGetMin, listToGetMin.stream().mapToInt(Integer::intValue).sum());
	}

	public MinMaxOutput getMaxSum() {
		List<Integer> listToGetMax = v.subList(1, v.size());
		return new MinMaxOutput(listToGetMax, listToGetMax.stream().mapToInt(Integer::intValue).sum());
	}

}