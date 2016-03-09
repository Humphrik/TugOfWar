package gamestuff;

public class Countdown extends Thread{ //Countdown at the start of the game.
	public void run(){
		try{
			Game.addListener();
			Thread.sleep(1000);
			Game.label.setText("<- - - - - -2- - - - - ->");
			Thread.sleep(1000);
			Game.label.setText("<- - - - - -1- - - - - ->");
			Thread.sleep(1000);
			Game.label.setText("<- - - - - -TUG!- - - - - ->");
			Game.started = true; //Game begins
		} catch(InterruptedException e){ //Too Early
			Game.label.setText("<- - - - - -EARLY- - - - - ->");
			if(Game.leftFalseStarted){ //If left false started.
				Game.leftPrompt.setText("LOSE");
				Game.rightPrompt.setText("WIN ");
			}else{ //If right false started.
				Game.leftPrompt.setText("WIN");
				Game.rightPrompt.setText("LOSE");
			}
		}
	}
}
