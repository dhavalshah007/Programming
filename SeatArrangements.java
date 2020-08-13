import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SeatNumbers {

	public static void main(String a[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> fixedEvenData = new HashMap<>();
		fixedEvenData.put(1, 11);
		fixedEvenData.put(2, 9);
		fixedEvenData.put(3, 7);
		fixedEvenData.put(4, 5);
		fixedEvenData.put(5, 3);
		fixedEvenData.put(6, 1);
		fixedEvenData.put(0, 1);
		Map<Integer, Integer> fixedOddData = new HashMap<>();
		fixedOddData.put(1, 1);
		fixedOddData.put(2, 3);
		fixedOddData.put(3, 5);
		fixedOddData.put(4, 7);
		fixedOddData.put(5, 9);
		fixedOddData.put(6, 11);
		fixedOddData.put(0, 11);
		Map<Integer, String> fixedSeatData = new HashMap<>();
		fixedSeatData.put(0, "WS");
		fixedSeatData.put(1, "WS");
		fixedSeatData.put(2, "MS");
		fixedSeatData.put(3, "AS");
		fixedSeatData.put(4, "AS");
		fixedSeatData.put(5, "MS");
		fixedSeatData.put(6, "WS");

		int n = Integer.parseInt(br.readLine());
		int returnArray[] = new int[n];
		for (int i = 0; i < n; i++) {
			int seatNumber = 0;
			int data = Integer.parseInt(br.readLine());
			int findSeatReference = data % 6;
			if (data % 6 == 0) {
				if ((data / 6) % 2 == 0) {
					seatNumber = data - fixedOddData.get(findSeatReference);
				} else {
					seatNumber = data + fixedEvenData.get(findSeatReference);
				}
			} else if ((data / 6) % 2 == 0) {
				seatNumber = data + fixedEvenData.get(findSeatReference);
			} else {
				seatNumber = data - fixedOddData.get(findSeatReference);
			}
			returnArray[i] = seatNumber;
		}
		Arrays.stream(returnArray).forEach(e -> System.out.println(e + " " + fixedSeatData.get(e % 6)));
	}
}
