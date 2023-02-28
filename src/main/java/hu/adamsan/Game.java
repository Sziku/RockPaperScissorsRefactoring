package hu.adamsan;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

class Game {

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
    private Scanner scanner;
    private String userChoice;
    private final Random random;

    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public Game(String userChoice, Random random) {
        this.userChoice = userChoice;
        this.random = random;
    }


    public void invoke() {
        println("Do you pick rock, paper, or scissors?");

        String playerChoice = getPlayerChoice();

        if (!isValidChoice(playerChoice)) {
            println("Move not recognized! Please try again.");
            //invoke();
        }else {
            int computerNumber = random.nextInt(3);
            String computerMoveChoice = getComputerMoveChoice(computerNumber);

            println("The computer chose: " + computerMoveChoice);

            printResult(playerChoice, computerMoveChoice);
        }


    }

    private void printResult(String playerChoice, String computerMoveChoice) {
        if (Objects.equals(playerChoice, computerMoveChoice)) {
            println("It's a tie!");
        } else if (Objects.equals(playerChoice, ROCK) && computerMoveChoice.equals(PAPER)) {
            println("Paper beats rock. The computer wins!");
        } else if (Objects.equals(playerChoice, ROCK) && computerMoveChoice.equals(SCISSORS)) {
            println("Rock beats scissors. Player wins!");
        } else if (Objects.equals(playerChoice, PAPER) && computerMoveChoice.equals(ROCK)) {
            println("Paper beats rock. Player wins!");
        } else if (Objects.equals(playerChoice, PAPER) && computerMoveChoice.equals(SCISSORS)) {
            println("Scissors beats paper. The computer wins!");
        } else if (Objects.equals(playerChoice, SCISSORS) && computerMoveChoice.equals(ROCK)) {
            println("Rock beats scissors. The computer wins!");
        } else if(Objects.equals(playerChoice, SCISSORS) && computerMoveChoice.equals(PAPER)){
            println("Scissors beats paper. Player wins!");
        }
    }

    private static boolean isValidChoice(String playerChoice) {
        return ROCK.equals(playerChoice) || PAPER.equals(playerChoice) || SCISSORS.equals(playerChoice);
    }

    private static String getComputerMoveChoice(int computerNumber) {
        String[] choices = {ROCK, PAPER, SCISSORS};
        return choices[computerNumber];
    }

    private String getPlayerChoice() {
        return (userChoice == null) ? scanner.nextLine() : userChoice;
    }

    private void println(String line) {
        System.out.println(line);
    }
}
