package application;
	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    Button btn1;
    Button btn2;
    Button btn3;
    Rectangle rect;
    
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
            	try {
					guardarCambioArchivo(color);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }			
        });
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String color = btn2.getText();
            	cambiarColor(color);
            	try {
					guardarCambioArchivo(color);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String color = btn3.getText();
            	cambiarColor(color);
            	try {
					guardarCambioArchivo(color);
				} catch (IOException e) {
					e.printStackTrace();
				}
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
        
        primaryStage.setTitle("TARE A01-AOP");
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
    
    private void guardarCambioArchivo(String color) throws IOException {
        BufferedWriter bw =abrirArchivo();
        SimpleDateFormat dateFormat  = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        bw.append("Color: "+color+"- hora: "+dateFormat.format(date));
        bw.newLine();
        cerrarArchivo(bw);        
    }

	private BufferedWriter abrirArchivo() throws IOException {		
		return new BufferedWriter(new FileWriter(new File("Color.txt"),true));
	}
	private void cerrarArchivo(BufferedWriter bw) throws IOException {		
		bw.close();
	}
}



