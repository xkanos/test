package gui;

import game.*;
import javafx.scene.control.*;

public class EnergyOfWarriors extends TextField implements ClashFollower {
	private Game game;
	private int energy;

	public EnergyOfWarriors(Game game) {	
		super();
		this.game = game;
	}
	
	public void inform() {
		energy = 0;
		
		for (int i = 0; i < game.getNumberOfWarriors(); ++i)
			energy += game.getKnight(i).getEnergy() + game.getOgre(i).getEnergy();

		setText(Integer.toString(energy));
	}
}
