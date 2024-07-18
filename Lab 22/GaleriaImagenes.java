import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GaleriaImagenes extends Application {

  private List<Image> imagenes = new ArrayList<>();
  private int indiceActual = 0;
  private ImageView vistaImagen;

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Gallery 2");

    vistaImagen = new ImageView();
    vistaImagen.setFitWidth(400);
    vistaImagen.setFitHeight(300);
    vistaImagen.setPreserveRatio(true);

    Button btnAnterior = new Button("Anterior");
    Button btnSiguiente = new Button("Siguiente");
    Button btnCargar = new Button("Cargar Imagen");

    estilizarBoton(btnAnterior);
    estilizarBoton(btnSiguiente);
    estilizarBoton(btnCargar);

    btnAnterior.setOnAction(e -> mostrarImagenAnterior());
    btnSiguiente.setOnAction(e -> mostrarImagenSiguiente());
    btnCargar.setOnAction(e -> cargarImagen(primaryStage));

    HBox hbox = new HBox(10, btnAnterior, btnSiguiente, btnCargar);
    hbox.setAlignment(Pos.CENTER);

    VBox vbox = new VBox(10, vistaImagen, hbox);
    vbox.setAlignment(Pos.CENTER);
    vbox.setStyle("-fx-background-color: #f0f0f0;");

    Scene scene = new Scene(vbox, 450, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void cargarImagen(Stage stage) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif"));
    File file = fileChooser.showOpenDialog(stage);
    if (file != null) {
      Image imagen = new Image(file.toURI().toString());
      imagenes.add(imagen);
      indiceActual = imagenes.size() - 1;
      mostrarImagenActual();
    }
  }
  private void mostrarImagenAnterior() {
    if (!imagenes.isEmpty()) {
      indiceActual = (indiceActual > 0) ? indiceActual - 1 : imagenes.size() - 1;
      mostrarImagenActual();
    }
  }
  private void mostrarImagenSiguiente() {
    if (!imagenes.isEmpty()) {
      indiceActual = (indiceActual < imagenes.size() - 1) ? indiceActual + 1 : 0;
      mostrarImagenActual();
    }
  }
  private void mostrarImagenActual() {
    if (!imagenes.isEmpty()) {
      vistaImagen.setImage(imagenes.get(indiceActual));
    }
  }
  private void estilizarBoton(Button btn) {
    btn.setStyle("-fx-background-color: #fab4e6; -fx-text-fill: white; -fx-font-size: 14px;");
    btn.setPrefWidth(120);
    btn.setPrefHeight(30);
  }
  public static void main(String[] args) {
    launch(args);
  }
}