import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.*;

public class EditorTextoSimple extends Application {

  private TextArea areaTexto;
  private boolean negritaActiva = false;
  private boolean cursivaActiva = false;
  private boolean subrayadoActivo = false;

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("NotePad --");

    areaTexto = new TextArea();
    areaTexto.setWrapText(true);
    areaTexto.setFont(Font.font("Arial", 14));

    MenuBar menuBar = new MenuBar();
    menuBar.setStyle("-fx-background-color: #f0f0f0;");

    Menu menuArchivo = new Menu("Archivo");
    MenuItem itemNuevo = new MenuItem("Nuevo");
    MenuItem itemAbrir = new MenuItem("Abrir");
    MenuItem itemGuardar = new MenuItem("Guardar");
    menuArchivo.getItems().addAll(itemNuevo, itemAbrir, itemGuardar);

    Menu menuFormato = new Menu("Formato");
    CheckMenuItem itemNegrita = new CheckMenuItem("Negrita");
    CheckMenuItem itemCursiva = new CheckMenuItem("Cursiva");
    CheckMenuItem itemSubrayado = new CheckMenuItem("Subrayado");
    menuFormato.getItems().addAll(itemNegrita, itemCursiva, itemSubrayado);

    menuBar.getMenus().addAll(menuArchivo, menuFormato);

    itemNuevo.setOnAction(e -> areaTexto.clear());
    itemAbrir.setOnAction(e -> abrirArchivo(primaryStage));
    itemGuardar.setOnAction(e -> guardarArchivo(primaryStage));

    itemNegrita.setOnAction(e -> aplicarNegrita());
    itemCursiva.setOnAction(e -> aplicarCursiva());
    itemSubrayado.setOnAction(e -> aplicarSubrayado());

    VBox vbox = new VBox(menuBar, areaTexto);
    Scene scene = new Scene(vbox, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void abrirArchivo(Stage stage) {
    FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showOpenDialog(stage);
    if (file != null) {
      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = reader.readLine()) != null) {
          content.append(line).append("\n");
        }
        areaTexto.setText(content.toString());
      } catch (IOException e) {
        mostrarAlerta("Error al abrir el archivo");
      }
    }
  }

  private void guardarArchivo(Stage stage) {
    FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showSaveDialog(stage);
    if (file != null) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write(areaTexto.getText());
      } catch (IOException e) {
        mostrarAlerta("Error al guardar el archivo");
      }
    }
  }

  private void aplicarNegrita() {
    negritaActiva = !negritaActiva;
    actualizarEstilo();
  }

  private void aplicarCursiva() {
    cursivaActiva = !cursivaActiva;
    actualizarEstilo();
  }

  private void aplicarSubrayado() {
    subrayadoActivo = !subrayadoActivo;
    actualizarEstilo();
  }

  private void actualizarEstilo() {
    FontWeight weight = negritaActiva ? FontWeight.BOLD : FontWeight.NORMAL;
    FontPosture posture = cursivaActiva ? FontPosture.ITALIC : FontPosture.REGULAR;
    Font font = Font.font("Arial", weight, posture, 14);
    areaTexto.setFont(font);

    StringBuilder style = new StringBuilder();
    if (subrayadoActivo) {
      style.append("-fx-underline: true;");
    }
    areaTexto.setStyle(style.toString());
  }

  private void mostrarAlerta(String mensaje) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
  }

  public static void main(String[] args) {
    launch(args);
  }
}