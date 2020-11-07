package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
    Button btn1;
    Button btn2;
    Button btn3;
	@Override
	public void start(Stage primaryStage) {
    	btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn1.setText("Amarillo");
        btn2.setText("Azul");
        btn3.setText("Rojo");
		System.out.println("d");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

