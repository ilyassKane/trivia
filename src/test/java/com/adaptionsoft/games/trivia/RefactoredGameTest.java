package com.adaptionsoft.games.trivia;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class RefactoredGameTest {

    @Test
    public void output_refactoredGame_should_be_the_same_as_output_game()  throws Exception{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        InputStream triviaStream = classloader.getResourceAsStream("trivia.txt");
        InputStreamReader triviaStreamReader = new InputStreamReader(triviaStream, StandardCharsets.UTF_8);

        InputStream refactoredTriviaStream = classloader.getResourceAsStream("refactoredTrivia.txt");
        InputStreamReader refactoredTriviaStreamReader = new InputStreamReader(refactoredTriviaStream, StandardCharsets.UTF_8);

        BufferedReader expected = new BufferedReader(triviaStreamReader);
        BufferedReader actual = new BufferedReader(refactoredTriviaStreamReader);
        
        String line;
        while ((line = expected.readLine()) != null) {

            Assertions.assertEquals(line, actual.readLine());
        }
    }
}