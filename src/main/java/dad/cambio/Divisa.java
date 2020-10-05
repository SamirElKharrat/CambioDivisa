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

public class Divisa extends Application {
	
	private Button botonComprobar;
	private Button botonAcabar;
	private TextField origentext, finaltext;
	private ComboBox <String> comienzoCombo;
	private ComboBox cambioCombo;
	
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
		cambioCombo = new ComboBox();
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

	private void onCambiarAction(ActionEvent e) {

		
	}


	public static void main(String[] args) {
		Application.launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
