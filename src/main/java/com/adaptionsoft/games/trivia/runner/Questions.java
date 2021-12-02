package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Player;

import java.util.LinkedList;

public class Questions {
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public Questions(){
        initQuestions();
    }

    private void initQuestions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    private String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public void askQuestion(Player player) {
        if (player.currentCategory() == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (player.currentCategory() == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (player.currentCategory() == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (player.currentCategory() == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }
}
