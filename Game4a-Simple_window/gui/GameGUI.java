package gui;

import game.*;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;


public class GameGUI extends Application {
	
	public void start(Stage mainWindow) {
		mainWindow.setTitle("Clash");
		mainWindow.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}


/*
	private Button startClash = new Button("Start Clash");
	private TextArea output = new TextArea();
	
	public void start(Stage mainWindow) {
		mainWindow.setTitle("Clash");
		
		FlowPane pane = new FlowPane();
		
		pane.getChildren().add(startClash);
		pane.getChildren().add(output);
		
		mainWindow.setScene(new Scene(pane, 500, 300));
		mainWindow.show();
	}
*/


/*
		class ClashHandler implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				Game game = new Game(7, 3, 5, new AlternateSwordsGameSetup());
				output.appendText(game.clash());
			}
		}
		
		startClash.setOnAction(new ClashHandler());
*/

