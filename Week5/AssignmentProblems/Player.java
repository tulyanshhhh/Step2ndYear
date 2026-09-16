import java.util.Arrays;
import java.util.Scanner;
public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;
    public Player(String name,
                  int matchesPlayed,
                  double battingAverage,
                  boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }
    static boolean isDraftable(int matchesPlayed) {
       return matchesPlayed >= 10;
    }
    static boolean isDraftable(int matchesPlayed,
                               boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }
    @Override
    public int compareTo(Player other) {
        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }
    static String draftAndRank(Player[] players) {
        Player[] draftable =
                new Player[players.length];
        int count = 0;
        for (Player player : players) {
            if (isDraftable(player.matchesPlayed)
                    || isDraftable(
                    player.matchesPlayed,
                    player.injured)) {
                draftable[count] = player;
                count++;
            }
        }
        Player[] finalList =
                Arrays.copyOf(draftable, count);
        Arrays.sort(finalList);
        String result = "";
        for (int i = 0; i < finalList.length; i++) {
            result = result
                    + (i + 1)
                    + ". "
                    + finalList[i].name;
            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nPlayer " + (i + 1));
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter matches played: ");
            int matchesPlayed = scanner.nextInt();
            System.out.print("Enter batting average: ");
            double battingAverage = scanner.nextDouble();
            System.out.print("Is player injured? (true/false): ");
            boolean injured = scanner.nextBoolean();
            scanner.nextLine();
            players[i] = new Player(
                    name,
                    matchesPlayed,
                    battingAverage,
                    injured
            );
        }
        String result = draftAndRank(players);
        System.out.println("\nDraft Ranking:");
        System.out.println(result);
        scanner.close();
    }
}