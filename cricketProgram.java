package cricketgame;
import java.util.*;
class CricketGame {
    private int totalRuns;
    private int wickets;
    private int balls;
    private int overs;
    private int innings;
    private int target;
    private int totalOvers;
    private boolean isSecondInnings;

    public CricketGame(int totalOvers) {
        this.totalOvers = totalOvers;
        this.innings = 1;
        resetInnings();
    }

    private void resetInnings() {
        totalRuns = 0;
        wickets = 0;
        balls = 0;
        overs = 0;
    }

    // Clear console screen using ANSI escape codes
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Display scoreboard dynamically
    private void displayScore() {
        clearScreen();
        System.out.println("========================================");
        System.out.println("    CRICKET EMPIRE CONSOLE SCOREBOARD");
        System.out.println("========================================");
        System.out.println("Score: " + totalRuns + "/" + wickets + "\t\tOver: " + overs + "." + (balls % 6));
        System.out.println("Innings: " + innings + (isSecondInnings ? " (Team 2)" : " (Team 1)"));
        System.out.println("========================================");
        System.out.println("Balls bowled: " + balls);
        System.out.println("----------------------------------------");
        System.out.println("Options:");
        System.out.println("1. 1 Run\t2. 2 Runs\t3. 3 Runs\t4. 4 Runs");
        System.out.println("5. 6 Runs\t6. 0 Run\t7. OUT");
        System.out.println("8. WIDE\t\t9. NO BALL");
        System.out.println("----------------------------------------");
        System.out.print("Enter option: ");
    }

    private void addRun(int runs, boolean isExtra) {
        totalRuns += runs;
        if (!isExtra) balls++;
        checkOver();
    }

    private void wideBall() {
        totalRuns++;
        System.out.println("Wide ball! +1 run");
    }

    private void noBall() {
        totalRuns++;
        System.out.println("No ball! +1 run");
    }

    private void wicket() {
        wickets++;
        balls++;
        System.out.println("Wicket!");
        checkOver();
        if (wickets == 10) endInnings();
    }

    private void checkOver() {
        if (balls % 6 == 0 && balls > 0) {
            overs++;
            if (overs == totalOvers) {
                endInnings();
            }
        }
    }

    private void endInnings() {
        System.out.println("\nInnings " + innings + " completed. Final score: " + totalRuns + "/" + wickets);
        if (innings == 1) {
            target = totalRuns + 1;
            innings++;
            resetInnings();
            isSecondInnings = true;
            System.out.println("\nTeam 2 needs " + target + " runs to win!");
            pauseMenu();
        } else {
            displayResult();
        }
    }

    private void displayResult() {
        clearScreen();
        System.out.println("====================================");
        System.out.println(" MATCH RESULT ");
        if (totalRuns >= target)
            System.out.println("Team 2 wins by " + (10 - wickets) + " wickets!");
        else
            System.out.println("Team 1 wins by " + (target - totalRuns - 1) + " runs!");
        System.out.println("====================================");
        System.exit(0);
    }

    private void pauseMenu() {
        System.out.println("Press Enter to continue...");
        try { System.in.read(); } catch (Exception e) {}
    }

    public void startMatch() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayScore();
            int option;
            try {
                option = sc.nextInt();
            } catch (Exception e) {
                sc.nextLine();
                continue;
            }

            switch (option) {
                case 1 -> addRun(1, false);
                case 2 -> addRun(2, false);
                case 3 -> addRun(3, false);
                case 4 -> addRun(4, false);
                case 5 -> addRun(6, false);
                case 6 -> addRun(0, false);
                case 7 -> wicket();
                case 8 -> wideBall();
                case 9 -> noBall();
                default -> System.out.println("Invalid option!");
            }

            // Check if Team 2 already chased the target
            if (isSecondInnings && totalRuns >= target) {
                displayResult();
            }
        }
    }
}

public class cricketProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total overs: ");
        int overs = sc.nextInt();

        CricketGame game = new CricketGame(overs);
        game.startMatch();
    }
}
