import java.util.Arrays;

public class Lab2prog1 {

    private static int[] numbers; // Static variable to store the input array

    // Static method to find and print the top K numbers with the highest occurrences
    public static void findTopKNumbers(int K) {
        // Sort the array in ascending order
        Arrays.sort(numbers);

        // Count the frequency of each number
        int[] frequency = new int[numbers.length];
        int currentNumber = numbers[0];
        int count = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == currentNumber) {
                count++;
            } else {
                frequency[i - 1] = count;
                currentNumber = numbers[i];
                count = 1;
            }
        }
        frequency[numbers.length - 1] = count;

        // Create an array of indices and sort it based on frequency and value
        Integer[] indices = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> {
            int freqCompare = Integer.compare(frequency[b], frequency[a]);
            if (freqCompare != 0) {
                return freqCompare;
            }
            return Integer.compare(numbers[b], numbers[a]);
        });

        // Print the top K numbers with the highest occurrences
        System.out.println("Top " + K + " numbers with highest occurrences:");

        for (int i = 0; i < K; i++) {
            int index = indices[i];
            System.out.println(numbers[index] + " - Frequency: " + frequency[index]);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        numbers = new int[]{4, 2, 3, 4, 2, 7, 8, 4, 1, 2, 7, 8, 4, 7, 8};
        int K = 3;
        findTopKNumbers(K);
    }
}
