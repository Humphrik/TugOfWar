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
			Game.label.setText("<- - - - - GO! - - - - ->");
			Game.started = true; //Game begins
			
			
			int timer = 60;
			while (timer >= 0 && !Game.gameOver){
				Thread.sleep(1000);
				timer--;
				if(!Game.gameOver){
				Game.label.setText("<- - - - - -" + timer + "- - - - - ->");
				}
			}
			if (!Game.gameOver){
				if(Game.n > 50){
					Game.n = 100;
					Game.checkWin();
				} else if (Game.n < 50){
					Game.n = 0;
					Game.checkWin();
				} else {
					Game.leftPrompt.setText("DRAW");
					Game.rightPrompt.setText("DRAW" );
					Game.label.setText("<- - - - - -OVER- - - - - ->");
				}
			}
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
