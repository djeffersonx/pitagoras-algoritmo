package br.com.djefferson.v2;

import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {

	private static final int ONE_BILLION = 1000000000;
	private static final int V_MIN_VALUE = ~ONE_BILLION;
	private static final int V_MAX_VALUE = ONE_BILLION;

	public static void main(String[] args) {
		algorithm(new Integer[] { 4, -3, 7, 8, 2 });
	}

	private static void algorithm(Integer[] vInput) {

		Supplier<Stream<Integer>> stream = () -> Stream.of(vInput);

		stream.get().filter(v -> v > V_MAX_VALUE || v < V_MIN_VALUE).findAny()
				.ifPresent(i -> new InvalidParameterException(
						"Valor de V inválido, entre com um valor entre " + V_MIN_VALUE + " e " + V_MAX_VALUE + ""));

		long streamCount = stream.get().count();
		if (!(streamCount > 2 && streamCount < 10)) {
			throw new InvalidParameterException("Valor de N inválido, entre com um valor entre 2 e 10");
		}

		List<Integer> v = stream.get().collect(Collectors.toList());
		v.sort(Comparator.naturalOrder());

		List<Integer> listToCalcMax = v.subList(1, v.size());
		List<Integer> listToCalcMin = v.subList(0, v.size() - 1);

		int max = listToCalcMax.stream().mapToInt(Integer::intValue).sum();
		int min = listToCalcMin.stream().mapToInt(Integer::intValue).sum();

		System.out.println(formattedOutput(listToCalcMin, min));
		System.out.println(formattedOutput(listToCalcMax, max));

	}

	private static String formattedOutput(List<Integer> listToCalcMax, int max) {
		return listToCalcMax.stream().map(e -> e.toString()).collect(Collectors.joining(" + ")) + " = " + max;
	}

}
