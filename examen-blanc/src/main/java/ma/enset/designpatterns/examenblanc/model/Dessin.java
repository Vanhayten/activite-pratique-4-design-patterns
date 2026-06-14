package ma.enset.designpatterns.examenblanc.model;

import ma.enset.designpatterns.examenblanc.strategy.TraitementStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dessin implements Serializable {
    private List<Figure> figures = new ArrayList<>();
    private transient TraitementStrategy traitementStrategy;

    public void setTraitementStrategy(TraitementStrategy traitementStrategy) {
        this.traitementStrategy = traitementStrategy;
    }

    public void traiter() {
        if (traitementStrategy != null) {
            traitementStrategy.traiter(figures);
        } else {
            System.out.println("Aucune stratégie de traitement définie pour le dessin.");
        }
    }

    public void ajouterFigure(Figure figure) {
        figures.add(figure);
    }

    public void supprimerFigure(Figure figure) {
        figures.remove(figure);
    }

    public void afficherDessin() {
        System.out.println("====== Contenu du Dessin ======");
        for (Figure f : figures) {
            f.dessiner();
        }
        System.out.println("===============================");
    }

    public void serialiser(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Dessin sérialisé avec succès dans : " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Dessin deserialiser(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Dessin dessin = (Dessin) ois.readObject();
            System.out.println("Dessin désérialisé avec succès depuis : " + filename);
            return dessin;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
