package ma.enset.designpatterns.examenblanc.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ma.enset.designpatterns.examenblanc.model.*;
import ma.enset.designpatterns.examenblanc.observer.Parametrage;
import ma.enset.designpatterns.examenblanc.observer.Observer;

public class DessinApp extends Application implements Observer {
    private Dessin dessin;
    private Parametrage parametrage;
    private Canvas canvas;
    
    // UI Controls
    private Slider epaisseurSlider;
    private ColorPicker contourColorPicker;
    private ColorPicker remplissageColorPicker;

    @Override
    public void start(Stage primaryStage) {
        parametrage = new Parametrage();
        dessin = new Dessin();
        
        // Populate with dummy data
        Cercle c1 = new Cercle(new Point(100, 100), 50);
        Rectangle r1 = new Rectangle(new Point(200, 50), 120, 80);
        
        dessin.ajouterFigure(c1);
        dessin.ajouterFigure(r1);
        
        parametrage.addObserver(c1);
        parametrage.addObserver(r1);
        parametrage.addObserver(this); // The UI observes parametrage to redraw

        BorderPane root = new BorderPane();
        canvas = new Canvas(600, 400);
        root.setCenter(canvas);

        VBox controls = new VBox(10);
        controls.setPadding(new Insets(10));
        
        epaisseurSlider = new Slider(1, 10, 1);
        contourColorPicker = new ColorPicker(Color.BLACK);
        remplissageColorPicker = new ColorPicker(Color.WHITE);
        
        Button applyBtn = new Button("Appliquer Paramétrage");
        applyBtn.setOnAction(e -> applyParametrage());

        controls.getChildren().addAll(
            new Label("Épaisseur Contour:"), epaisseurSlider,
            new Label("Couleur Contour:"), contourColorPicker,
            new Label("Couleur Remplissage:"), remplissageColorPicker,
            applyBtn
        );

        root.setRight(controls);

        Scene scene = new Scene(root, 800, 450);
        primaryStage.setTitle("Éditeur de Dessin JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        draw();
    }

    private void applyParametrage() {
        int epaisseur = (int) epaisseurSlider.getValue();
        int contourHex = toRGBCode(contourColorPicker.getValue());
        int rempHex = toRGBCode(remplissageColorPicker.getValue());
        
        parametrage.setParametres(epaisseur, contourHex, rempHex);
    }
    
    public static int toRGBCode(Color color) {
        return ( (int) (color.getRed() * 255) << 16 ) |
               ( (int) (color.getGreen() * 255) << 8 ) |
               ( (int) (color.getBlue() * 255) );
    }

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        int epaisseur = parametrage.getEpaisseurContour();
        Color stroke = Color.rgb((parametrage.getCouleurContour() >> 16) & 0xFF, (parametrage.getCouleurContour() >> 8) & 0xFF, parametrage.getCouleurContour() & 0xFF);
        Color fill = Color.rgb((parametrage.getCouleurRemplissage() >> 16) & 0xFF, (parametrage.getCouleurRemplissage() >> 8) & 0xFF, parametrage.getCouleurRemplissage() & 0xFF);
        
        gc.setLineWidth(epaisseur);
        gc.setStroke(stroke);
        gc.setFill(fill);
        
        // Static drawing simulation based on state
        // Cercle 1
        gc.fillOval(100 - 50, 100 - 50, 100, 100);
        gc.strokeOval(100 - 50, 100 - 50, 100, 100);
        
        // Rectangle 1
        gc.fillRect(200, 50, 120, 80);
        gc.strokeRect(200, 50, 120, 80);
    }

    @Override
    public void update(Parametrage parametrage) {
        draw();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
