package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		
		// Lo primero que crearemos sera los HBox en donde almacenaremos el tablero 
		// y el panel de control (flechas).
		HBox Hbox = new HBox();		
		
		
		////////////////////////////////Tablero///////////////////////////////
		
		//Con el GridPane creamos el tablero.
		GridPane tablero = new GridPane( );
		
		
		//Con los siguientes for() creamos la cuadricula, es decir i representa las columnas
		//y la j las filas, mencionamos el tablero ya creado y utilizamos REctangle para crear el rectangulo en donde
		//indicamos el tamaño, el color y nuestras funciones i y j.
		
		for(int i=0; i<5; i++)
		for(int j=0; j<5; j++)
			tablero.add(new Rectangle(50,50, Color.BEIGE), i,j);
		
		final Circle bola = new Circle(15,Color.RED);
		tablero.add(bola,2,2);
		
		GridPane.setHalignment(bola, HPos.CENTER);
		tablero.setGridLinesVisible(true);
		
		
		//////////////////////////////Panel de Control///////////////////////////////
		
		
		//Creamos el Panel de Control con el que moveremos la bola por el tablero, para ello utilizamos el GridPane
		
		GridPane panelControl = new GridPane();
		panelControl.setAlignment(Pos.CENTER);
		
		//Ahora pasamos a crear los botones arriba, abajo, izq y dcha, en Ubuntu Utilizamos ALTGR + Y = ← ;
		//ALTGR + U= ↓ ; ALTGR + I= → ; ALTGR + SHIFT + U = ↑
		
		Button upButton = new Button("↑");
		Button downButton = new Button("↓");
		Button rightButton = new Button("→");
		Button leftButton = new Button("←");
		
		//Añadimos nuestros botones al panel con su cordenadas como si fuera una cuadricula 3x3.
		
		panelControl.add(upButton, 1, 0);
		panelControl.add(downButton, 1, 2);
		panelControl.add(rightButton, 2, 1);
		panelControl.add(leftButton, 0, 1);
		
		//EVENTOS DE LOS BOTONES 
		

			upButton.setOnAction(new EventHandler<ActionEvent>(){	       
	        @Override
	        public void handle(ActionEvent t){
	        GridPane.setRowIndex(bola,GridPane.getRowIndex(bola)-1);
	        }
	        
	        });
			
			downButton.setOnAction(new EventHandler<ActionEvent>(){	       
		        @Override
		        public void handle(ActionEvent t){
		        GridPane.setRowIndex(bola,GridPane.getRowIndex(bola)+1);
		        }
		        
		        });
			
			
			rightButton.setOnAction(new EventHandler<ActionEvent>(){	       
		        @Override
		        public void handle(ActionEvent t){
		        GridPane.setColumnIndex(bola,GridPane.getColumnIndex(bola)+1);
		        }
		        
		        });
			
			
			leftButton.setOnAction(new EventHandler<ActionEvent>(){	       
		        @Override
		        public void handle(ActionEvent t){
		        GridPane.setColumnIndex(bola,GridPane.getColumnIndex(bola)-1);
		        }
		        
		        });
		
			
	
		
		Hbox.getChildren().addAll(panelControl, tablero);
		
		Scene escenario = new Scene(Hbox);
		primaryStage.setScene(escenario);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
