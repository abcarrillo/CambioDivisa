package Controlador;

import Modelo.Divisa;
import Vista.Pantalla;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.converter.NumberStringConverter;

public class DivisaController {

	private Divisa euro = new Divisa("Euro", 1.0);
	private Divisa libra = new Divisa("Libra", 0.8873);
	private Divisa dolar = new Divisa("Dolar", 1.2007);
	private Divisa yen = new Divisa("Euro", 133.59);
	private Divisa origen = euro;
	private Divisa destino = libra;
	private Pantalla pantalla = new Pantalla();
	private SimpleDoubleProperty cantidad = new SimpleDoubleProperty();

	public DivisaController() {
		
		pantalla.getOrigenText().textProperty().bindBidirectional(cantidad, new NumberStringConverter());

		pantalla.getOrigenCombo().valueProperty().addListener(listener -> {
			String seleccion = pantalla.getOrigenCombo().getSelectionModel().getSelectedItem().toString();
			
			switch (seleccion) {
			case "Euro": {
				origen = euro;
				break;
			}
			case "Dolar": {
				origen = dolar;
				break;
			}
			case "Libra": {
				origen = libra;
				break;
			}
			case "Yen": {
				origen = yen;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + seleccion);
			}
		});

		pantalla.getDestinoCombo().valueProperty().addListener(listener -> {
			String seleccion = pantalla.getDestinoCombo().getSelectionModel().getSelectedItem().toString();

			switch (seleccion) {
			case "Euro": {
				destino = euro;
				break;
			}
			case "Dolar": {
				destino = dolar;
				break;
			}
			case "Libra": {
				destino = libra;
				break;
			}
			case "Yen": {
				destino = yen;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + seleccion);
			}
		});
		
		pantalla.getCambiarButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				pantalla.getDestinoText().textProperty().set(Divisa.fromTo(origen, destino, cantidad.doubleValue())+"");
			}
		});;
	}

	public Divisa getDivisaOrigen() {
		return origen;
	}

	public Divisa getDivisaDestino() {
		return destino;
	}

	public Pantalla getPantalla() {
		return pantalla;
	}

}
