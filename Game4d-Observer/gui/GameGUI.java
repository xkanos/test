package gui;

import game.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;

public class GameGUI extends Application {
	private Button createWarriors = new Button("Create Warriors");
	private Button startClash = new Button("Start Clash");
	private TextField knights = new TextField();
	private TextField braveKnights = new TextField();
	private TextField badOgres = new TextField();
	private Label knightsLabel = new Label("Knights");
	private Label braveKnightsLabel = new Label("Brave knights");
	private Label badOgresLabel = new Label("Bad ogres");
	private TextArea output = new TextArea();
	private ScrollPane scroll = new ScrollPane();
		
	private EnergyOfWarriors energyOfWarriors;

	public void start(Stage mainWindow) {
		mainWindow.setTitle("Clash");
		
		FlowPane pane = new FlowPane();
		
		Game game = new Game();
		
		pane.getChildren().add(createWarriors);
		pane.getChildren().add(startClash);
		pane.getChildren().add(knights);
		pane.getChildren().add(knightsLabel);
		pane.getChildren().add(braveKnights);
		pane.getChildren().add(braveKnightsLabel);
		pane.getChildren().add(badOgres);
		pane.getChildren().add(badOgresLabel);
		pane.getChildren().add(output);
		
		scroll.setContent(pane);		
		
 		createWarriors.setOnAction(e -> {
			game.createWarriors(Integer.parseInt(knights.getText()),
					Integer.parseInt(braveKnights.getText()),
					Integer.parseInt(badOgres.getText()),
					new AlternateSwordsGameSetup());

			output.appendText("Warriors created.\n");
			}
		);

 		startClash.setOnAction(e -> output.appendText(game.clash()));
		
		energyOfWarriors = new EnergyOfWarriors(game);
		game.followClash(energyOfWarriors);
		pane.getChildren().add(energyOfWarriors);

//		mainWindow.setScene(new Scene(pane, 500, 300));
		mainWindow.setScene(new Scene(scroll, 500, 300));
		mainWindow.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
