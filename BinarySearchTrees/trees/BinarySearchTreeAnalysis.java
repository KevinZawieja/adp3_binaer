package trees;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BinarySearchTreeAnalysis {

    private static final String CSV_FILE_PATH = "bst_analysis.csv";

    public static void main(String[] args) {
        BinarySearchTreeAnalysis analysis = new BinarySearchTreeAnalysis();
        analysis.runAnalysis();
    }

    public void runAnalysis() {
        int minSize = 100;
        int maxSize = 10000;
        int stepSize = 100;
        int repetitions = 1000;

        double[] averagePathLengths = new double[(maxSize - minSize) / stepSize + 1];
        double[] theoreticalPathLengths = new double[(maxSize - minSize) / stepSize + 1];

        int index = 0;
        for (int size = minSize; size <= maxSize; size += stepSize) {
            int totalPathLength = 0;

            for (int i = 0; i < repetitions; i++) {
                ADSortedSetImpl<Integer> bst = new ADSortedSetImpl<>();
                Random random = new Random();

                for (int j = 0; j < size; j++) {
                    int key = random.nextInt(); // Generate random key
                    bst.add(key);
                }

                int randomKey = random.nextInt(); // Generate random key for measurement
                totalPathLength += bst.getPathLength(randomKey);
            }

            double averagePathLength = (double) totalPathLength / repetitions;
            averagePathLengths[index] = averagePathLength;
            theoreticalPathLengths[index] = 1.39 * (Math.log(size) / Math.log(2)) - 1.85;
            index++;
        }

        // Write the results to a CSV file
        writeResultsToCSV(minSize, maxSize, stepSize, averagePathLengths, theoreticalPathLengths);
    }

    public void writeResultsToCSV(int minSize, int maxSize, int stepSize, double[] averagePathLengths, double[] theoreticalPathLengths) {
        try (FileWriter writer = new FileWriter(CSV_FILE_PATH)) {
            // Write CSV header
            writer.write("Size,Average Path Length,Theoretical Path Length\n");

            // Write data rows
            for (int i = 0; i < averagePathLengths.length; i++) {
                int size = minSize + i * stepSize;
                double averagePathLength = averagePathLengths[i];
                double theoreticalPathLength = theoreticalPathLengths[i];

                writer.write(size + "," + averagePathLength + "," + theoreticalPathLength + "\n");
            }

            System.out.println("Results have been written to: " + CSV_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
