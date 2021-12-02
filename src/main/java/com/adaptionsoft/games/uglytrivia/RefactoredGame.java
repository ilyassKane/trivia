package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.trivia.runner.Questions;

import java.util.ArrayList;

public class RefactoredGame {
    ArrayList<Player> players = new ArrayList();
    Questions question;
    int currentPlayer = 0;

    public RefactoredGame(Questions question) {
        this.question = question;
    }

    public boolean add(Player player) {
        players.add(player);
        System.out.println(player.getName() + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public void roll(int roll) {
        System.out.println(getCurrentPlayer().getName() + " is the current player");
        System.out.println("They have rolled a " + roll);
        if (getCurrentPlayer().isInPenaltyBox()) {
            if ((roll % 2 != 0)) {
                getCurrentPlayer().setGettingOutOfPenaltyBox(true);
                System.out.println(getCurrentPlayer().getName() + " is getting out of the penalty box");
            } else {
                System.out.println(getCurrentPlayer().getName() + " is not getting out of the penalty box");
                getCurrentPlayer().setGettingOutOfPenaltyBox(false);
                return;
            }
        }
        getCurrentPlayer().setCurrentPosition(roll);
        this.question.askQuestion(getCurrentPlayer());
    }

    public boolean wasCorrectlyAnswered() {
        boolean winner;
        if (getCurrentPlayer().isInPenaltyBox()) {
            if (getCurrentPlayer().isGettingOutOfPenaltyBox()) {
                winner = getCurrentPlayer().isWinner("Answer was correct!!!!");
            } else {
                winner = true;
            }
        } else {
            winner = getCurrentPlayer().isWinner("Answer was corrent!!!!");
        }
        intCurrentPlayer();
        return winner;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrentPlayer().getName() + " was sent to the penalty box");
        getCurrentPlayer().setInPenaltyBox(true);
        intCurrentPlayer();
        return true;
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private void intCurrentPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) {
            currentPlayer = 0;
        }
    }
}
