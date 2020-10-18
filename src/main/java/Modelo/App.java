package Modelo;

import Controlador.DivisaController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	DivisaController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		controller = new DivisaController();
		
		Scene escena = new Scene(controller.getPantalla(), 320, 200);
		
		Stage stage = new Stage();
		stage.setTitle("CambioDivisa");
		stage.setScene(escena);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
