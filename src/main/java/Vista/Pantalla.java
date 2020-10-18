package Vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Pantalla extends VBox {
	
	private TextField origenText;
	private TextField destinoText;
	private ComboBox origenCombo;
	private ComboBox destinoCombo;
	private Button cambiarButton;
	
	public Pantalla() {
		super();
		
		
		//Fila de divisa de origen
		origenText = new TextField();
		origenText.setText("0");
		origenText.setPrefColumnCount(4);
		
		origenCombo = new ComboBox();
		origenCombo.getItems().addAll("Euro", "Libra", "Yen", "Dolar");
		origenCombo.getSelectionModel().select(0);
		
		
		HBox origenBox = new HBox();
		origenBox.setAlignment(Pos.BASELINE_CENTER);
		origenBox.setSpacing(5);
		origenBox.getChildren().addAll(origenText, origenCombo);
		
		//Fila de divisa de destino
		destinoText = new TextField();
		destinoText.setText("0");
		destinoText.setPrefColumnCount(4);
		
		destinoCombo = new ComboBox();
		destinoCombo.getItems().addAll("Euro", "Libra", "Yen", "Dolar");
		destinoCombo.getSelectionModel().select(1);
		
		HBox destinoBox = new HBox();
		destinoBox.setAlignment(Pos.BASELINE_CENTER);
		destinoBox.setSpacing(5);
		destinoBox.getChildren().addAll(destinoText, destinoCombo);
		
		//Boton de cambio de divisa
		cambiarButton = new Button("Cambiar");
		
		
		setSpacing(5);
		setFillWidth(false);
		setAlignment(Pos.CENTER);
		getChildren().addAll(origenBox, destinoBox, cambiarButton);
	}

	public TextField getOrigenText() {
		return origenText;
	}

	public TextField getDestinoText() {
		return destinoText;
	}


	public ComboBox getOrigenCombo() {
		return origenCombo;
	}

	public ComboBox getDestinoCombo() {
		return destinoCombo;
	}


	public Button getCambiarButton() {
		return cambiarButton;
	}

}
