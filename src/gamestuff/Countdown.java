package gamestuff;

public class Countdown extends Thread{
	public void run(){
		try{
			Game.addListener();
			Thread.sleep(1000);
			Game.label.setText("<- - - - - -2- - - - - ->");
			Thread.sleep(1000);
			Game.label.setText("<- - - - - -1- - - - - ->");
			Thread.sleep(1000);
			Game.label.setText("<- - - - - -GO- - - - - ->");
			Game.started = true;
		} catch(InterruptedException e){
			Game.label.setText("<- - - - - -EARLY- - - - - ->");
			if(Game.leftFalseStarted){
				Game.leftPrompt.setText("LOSE");
				Game.rightPrompt.setText("WIN ");
			}else{
				Game.leftPrompt.setText("WIN");
				Game.rightPrompt.setText("LOSE");
			}
		}
	}
}
