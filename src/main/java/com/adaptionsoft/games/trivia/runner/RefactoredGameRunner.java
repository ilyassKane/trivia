
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;
import com.adaptionsoft.games.uglytrivia.RefactoredGame;

import java.util.Random;


public class RefactoredGameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		RefactoredGame aGame = new RefactoredGame(new Questions());
		Player Chet = new Player("Chet");
		Player Pat = new Player("Pat");
		Player Sue = new Player("Sue");
		aGame.add(Chet);
		aGame.add(Pat);
		aGame.add(Sue);
		
		Random rand = new Random(7);
	
		do {
			
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
			
			
		} while (notAWinner);
		
	}
}
