package hu.adamsan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void rockRock() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("rock");
        Game g = new Game(userChoice, new Random(1L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "The computer chose: rock" + lineBreak+
                "It's a tie!"+lineBreak;
        assertEquals(expected, outputStream.toString());

    }
    @Test
    void rockPaper() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("rock");
        Game g = new Game(userChoice, new Random(2L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "The computer chose: paper" + lineBreak+
                "Paper beats rock. The computer wins!"+lineBreak;
        assertEquals(expected, outputStream.toString());

    }
    @Test
    void rockScissors() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("rock");
        Game g = new Game(userChoice, new Random(3L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "The computer chose: scissors" + lineBreak+
                "Rock beats scissors. Player wins!"+lineBreak;
        assertEquals(expected, outputStream.toString());

    }
    @Test
    void paperRock() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("paper");
        Game g = new Game(userChoice, new Random(1L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "The computer chose: rock" + lineBreak+
                "Paper beats rock. Player wins!"+lineBreak;
        assertEquals(expected, outputStream.toString());

    }
    @Test
    void paperPaper() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("paper");
        Game g = new Game(userChoice, new Random(2L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "The computer chose: paper" + lineBreak+
                "It's a tie!"+lineBreak;
        assertEquals(expected, outputStream.toString());

    }
    @Test
    void paperScissors() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("paper");
        Game g = new Game(userChoice, new Random(3L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "The computer chose: scissors" + lineBreak+
                "Scissors beats paper. The computer wins!"+lineBreak;
        assertEquals(expected, outputStream.toString());

    }
    @Test
    void scissorsRock() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("scissors");
        Game g = new Game(userChoice, new Random(1L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "The computer chose: rock" + lineBreak+
                "Rock beats scissors. The computer wins!"+lineBreak;
        assertEquals(expected, outputStream.toString());

    }
    @Test
    void scissorsPaper() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("scissors");
        Game g = new Game(userChoice, new Random(2L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "The computer chose: paper" + lineBreak+
                "Scissors beats paper. Player wins!"+lineBreak;
        assertEquals(expected, outputStream.toString());

    }
    @Test
    void scissorsScissors() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("scissors");
        Game g = new Game(userChoice, new Random(3L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "The computer chose: scissors" + lineBreak+
                "It's a tie!"+lineBreak;
        assertEquals(expected, outputStream.toString());

    }
    @Test
    void invalidUserChoice() {
        String lineBreak = System.lineSeparator();
        String userChoice = new String("kislabda");
        Game g = new Game(userChoice, new Random(3L));
        g.invoke();
        String expected="Do you pick rock, paper, or scissors?" + lineBreak+
                "Move not recognized! Please try again." + lineBreak ;
        assertEquals(expected, outputStream.toString());

    }
}