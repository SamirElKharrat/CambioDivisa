package dad.cambio;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Divisa extends Application {
	private Stage primaryStage;
	
	private DivisaPibote euro = new DivisaPibote("Euro", 1.0);
	private DivisaPibote libra = new DivisaPibote("Libra", 0.91);
	private DivisaPibote dolar = new DivisaPibote("Dolar", 1.17);
	private DivisaPibote yen = new DivisaPibote("Yen", 124.17);

	private DivisaPibote[] divisas = { euro, libra, dolar, yen };

	private Button botonComprobar;
	private Button botonAcabar;
	private TextField origentext, finaltext;
	private ComboBox<DivisaPibote> comienzoCombo;
	private ComboBox<DivisaPibote> cambioCombo;
	
	private void onCambiarAction(ActionEvent e) {
		try {
		Double cantidadOrigen = Double.parseDouble(origentext.getText());
		DivisaPibote divisaOrigen = comienzoCombo.getSelectionModel().getSelectedItem();
		DivisaPibote divisaDestino = cambioCombo.getSelectionModel().getSelectedItem();

		double cantidadDestino = divisaDestino.fromEuro(divisaOrigen.toEuro(cantidadOrigen));

		finaltext.setText("" + cantidadDestino);
		}catch (NumberFormatException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(primaryStage);
			alert.setTitle("Error");
			alert.setHeaderText("Debe introducir un número en la cantidad de origen.");
			alert.setContentText(ex.getMessage());
			
			alert.showAndWait();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// creamos un cuadro de texto
		origentext = new TextField("0");
		origentext.setPrefColumnCount(4);// indicamos el ancho del cuadro

		// creamos un combo box
		comienzoCombo = new ComboBox();
		comienzoCombo.getItems().addAll(divisas);
		comienzoCombo.getSelectionModel().selectFirst();

		// HBox
		HBox origenBox = new HBox();

		origenBox.setAlignment(Pos.BASELINE_CENTER);
		origenBox.setSpacing(5);
		origenBox.getChildren().addAll(origentext, comienzoCombo);

		// creamos un cuadro de texto
		finaltext = new TextField("0");
		finaltext.setPrefColumnCount(4);// indicamos el ancho del cuadro

		// creamos un combo box
		cambioCombo.getItems().addAll(divisas);
		cambioCombo.getSelectionModel().selectFirst();

		HBox finalBox = new HBox();

		finalBox.setAlignment(Pos.BASELINE_CENTER);
		finalBox.setSpacing(5);
		finalBox.getChildren().addAll(finaltext, cambioCombo);

		// creamos un bot�n
		botonComprobar = new Button("Cambiar");
		botonComprobar.setOnAction(e -> onCambiarAction(e));

		// creamos un panel con disposici�n vertical
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(origenBox, finalBox, botonComprobar);

		// creamos la escena
		Scene escena = new Scene(root, 320, 200);

		// configuramos la ventana
		primaryStage.setScene(escena);
		primaryStage.setTitle("CambioDivisa");
		primaryStage.show();
	}



	public static void main(String[] args) {
		Application.launch(args);
	}

}
