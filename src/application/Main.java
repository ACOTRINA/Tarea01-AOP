package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
    StackPane root1;
    VBox root2; 
    Rectangle rect;
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

        btn1.setStyle("-fx-background-color: pink;-fx-font-size: 1.5em;-fx-font-weight:bolder; -fx-font: bold italic 15pt \"Lucida Console\"");
        btn2.setStyle("-fx-background-color: pink;-fx-font-size: 1.5em;-fx-font-weight:bolder; -fx-font: bold italic 15pt \"Lucida Console\"");
        btn3.setStyle("-fx-background-color: pink;-fx-font-size: 1.5em;-fx-font-weight:bolder; -fx-font: bold italic 15pt \"Lucida Console\"");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String color = btn1.getText();
            	cambiarColor(color);
            }			
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String color = btn2.getText();
            	cambiarColor(color);
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String color = btn3.getText();
            	cambiarColor(color);
            }
        });

        rect = new Rectangle(300,250,300,250);
        rect.setFill(Color.TRANSPARENT);
        
        root1 = new StackPane();
        root2 = new VBox();
        root2.getChildren().addAll(btn1,btn2,btn3);
        root1.getChildren().addAll(rect,root2);
        
        root1.setAlignment(Pos.CENTER);
        root2.setAlignment(Pos.CENTER);
        root2.setSpacing(20);
        
        Scene scene = new Scene(root1,300,250);
        
        primaryStage.setTitle("TAREA01-AOP");
        primaryStage.setScene(scene);
        primaryStage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void cambiarColor(String color) {
        System.out.println(color);
        if(color=="Amarillo") rect.setFill(Color.YELLOW);
        else if(color=="Azul") rect.setFill(Color.BLUE);
        else rect.setFill(Color.RED);
    }
