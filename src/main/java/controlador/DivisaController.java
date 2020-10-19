package controlador;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.util.converter.NumberStringConverter;
import modelo.Divisa;
import vista.Pantalla;

public class DivisaController {
	
	// modelo

	private Divisa euro = new Divisa("Euro", 1.0);
	private Divisa libra = new Divisa("Libra", 0.8873);
	private Divisa dolar = new Divisa("Dolar", 1.2007);
	private Divisa yen = new Divisa("Yen", 133.59);

	private DoubleProperty cantidadOrigen = new SimpleDoubleProperty();
	private DoubleProperty cantidadDestino = new SimpleDoubleProperty();
	private ObjectProperty<Divisa> divisaOrigen = new SimpleObjectProperty<Divisa>();
	private ObjectProperty<Divisa> divisaDestino = new SimpleObjectProperty<Divisa>();
	
	// vista
	
	private Pantalla<Divisa> pantalla = new Pantalla<>();

	public DivisaController() {
		
		pantalla.getOrigenCombo().getItems().addAll(euro, libra, dolar, yen);
		
		pantalla.getDestinoCombo().getItems().addAll(euro, libra, dolar, yen);
		
		pantalla.getOrigenText().textProperty().bindBidirectional(cantidadOrigen, new NumberStringConverter());

		pantalla.getDestinoText().textProperty().bindBidirectional(cantidadDestino, new NumberStringConverter());
		
		divisaOrigen.bind(pantalla.getOrigenCombo().getSelectionModel().selectedItemProperty());

		divisaDestino.bind(pantalla.getDestinoCombo().getSelectionModel().selectedItemProperty());
		
		pantalla.getCambiarButton().setOnAction(e -> onCambiarDivisaAction(e));
	}

	private void onCambiarDivisaAction(ActionEvent e) {
		cantidadDestino.set(Divisa.fromTo(divisaOrigen.get(), divisaDestino.get(), cantidadOrigen.get()));
	}

	public Pantalla<Divisa> getPantalla() {
		return pantalla;
	}

}
