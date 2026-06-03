public class CO5 {

    static void swap(int[] scores, int i, int j) {
        int temp = scores[i];
        scores[i] = scores[j];
        scores[j] = temp;
    }

    static int partition(int[] scores, int low, int high) {

        int pivot = scores[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (scores[j] > pivot) {
                i++;
                swap(scores, i, j);
            }
        }

        swap(scores, i + 1, high);

        return i + 1;
    }

    static void quickSort(int[] scores, int low, int high) {

        if (low < high) {

            int pi = partition(scores, low, high);

            quickSort(scores, low, pi - 1);
            quickSort(scores, pi + 1, high);
        }
    }

    static void displayScores(int[] scores) {

        for (int score : scores)
            System.out.print(score + " ");

        System.out.println();
    }

    public static void main(String[] args) {

        int[] playerScores = {
                890, 1200, 760, 1450,
                980, 1100, 1670, 1340
        };

        System.out.println("========================================");
        System.out.println(" ONLINE GAMING LEADERBOARD USING QUICK SORT ");
        System.out.println("========================================");

        System.out.println("\nPlayer Scores Before Sorting:");
        displayScores(playerScores);

        quickSort(playerScores, 0, playerScores.length - 1);

        System.out.println("\nLeaderboard Rankings (Highest to Lowest):");
        displayScores(playerScores);

        System.out.println("\nTop Player Score: " + playerScores[0]);

        System.out.println("\nTop 3 Players:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Rank " + (i + 1) + " : " + playerScores[i]);
        }

        System.out.println("\nComplexity Analysis:");
        System.out.println("Best Case    : O(n log n)");
        System.out.println("Average Case : O(n log n)");
        System.out.println("Worst Case   : O(n²)");

        System.out.println("\nLeaderboard Generated Successfully.");
    }
}