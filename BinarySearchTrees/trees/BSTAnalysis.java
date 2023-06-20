package trees;

import java.io.FileWriter;
import java.io.IOException;

public class BSTAnalysis {
    private static final int MIN_TREE_SIZE = 100;
    private static final int MAX_TREE_SIZE = 10000;
    private static final int NUM_MEASUREMENTS = 1000;

    private static ADSortedSetImpl<Integer> tree;

    public static void main(String[] args) {
        tree = new ADSortedSetImpl<>();

        empiricalAnalysis();
    }

    public static void empiricalAnalysis() {
        try (FileWriter writer = new FileWriter("bst_analysis.csv")) {
            writer.write("n,BST Average Path Length,Function Value\n");

            for (int n = MIN_TREE_SIZE; n <= MAX_TREE_SIZE; n += 100) {
                long totalPathLength = 0;

                for (int i = 0; i < NUM_MEASUREMENTS; i++) {
                    ADSortedSetImpl<Integer> tree = new ADSortedSetImpl<>();
                    for (int j = 0; j < n; j++) {
                        tree.add((int) (Math.random() * n));
                    }
                    totalPathLength += calculateAveragePathLength(tree.getRoot());
                }

                double averagePathLength = (double) totalPathLength / NUM_MEASUREMENTS;
                double functionValue = (1.39 * Math.log(n) / Math.log(2)) - 1.85;

                writer.write(n + "," + averagePathLength + "," + functionValue + "\n".replace('.',','));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static long calculateAveragePathLength(ElementNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        long leftPathLength = calculatePathLength(node.getLeft());
        long rightPathLength = calculatePathLength(node.getRight());

        return leftPathLength + rightPathLength + 2;
    }

    private static long calculatePathLength(ElementNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        long leftPathLength = calculatePathLength(node.getLeft());
        long rightPathLength = calculatePathLength(node.getRight());

        return leftPathLength + rightPathLength + 1;
    }
}
