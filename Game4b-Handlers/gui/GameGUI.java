package gui;

import game.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;

public class GameGUI extends Application {
	private Button startClash = new Button("Start Clash");
	private TextField knights = new TextField();
	private TextField braveKnights = new TextField();
	private TextField badOgres = new TextField();
	private Label knightsLabel = new Label("Knights");
	private Label braveKnightsLabel = new Label("Brave knights");
	private Label badOgresLabel = new Label("Bad ogres");
	private TextArea output = new TextArea();
		
	public void start(Stage mainWindow) {
		mainWindow.setTitle("Clash");
		
		FlowPane pane = new FlowPane();
		
		Game game = new Game();
		
		pane.getChildren().add(startClash);
		pane.getChildren().add(knights);
		pane.getChildren().add(knightsLabel);
		pane.getChildren().add(braveKnights);
		pane.getChildren().add(braveKnightsLabel);
		pane.getChildren().add(badOgres);
		pane.getChildren().add(badOgresLabel);
		pane.getChildren().add(output);
				
		class ClashHandler implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				game.createWarriors(Integer.parseInt(knights.getText()),
						Integer.parseInt(braveKnights.getText()),
						Integer.parseInt(badOgres.getText()),
						new AlternateSwordsGameSetup());

				output.appendText(game.clash());
			}
		}
			    	
		startClash.setOnAction(new ClashHandler());

/*	
		startClash.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent event) {
				game.createWarriors(Integer.parseInt(knights.getText()),
						Integer.parseInt(braveKnights.getText()),
						Integer.parseInt(badOgres.getText()),
						new AlternateSwordsGameSetup());

				output.appendText(game.clash());
			}
	    });
*/
/*
	    EventHandler<ActionEvent> a = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				game.createWarriors(Integer.parseInt(knights.getText()),
						Integer.parseInt(braveKnights.getText()),
						Integer.parseInt(badOgres.getText()),
						new AlternateSwordsGameSetup());

				output.appendText(game.clash());
			}
		};

   		startClash.setOnAction(a::handle);
*/
/*
		//startClash.setOnAction((ActionEvent e) -> {
		startClash.setOnAction(e -> {
				game.createWarriors(Integer.parseInt(knights.getText()),
					Integer.parseInt(braveKnights.getText()),
					Integer.parseInt(badOgres.getText()),
					new AlternateSwordsGameSetup());

				output.appendText("Warriors created.\n");
			}
		);
*/
		
		mainWindow.setScene(new Scene(pane, 500, 300));
		mainWindow.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
