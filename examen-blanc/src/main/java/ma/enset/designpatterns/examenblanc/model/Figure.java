package ma.enset.designpatterns.examenblanc.model;

import ma.enset.designpatterns.examenblanc.observer.Observer;
import ma.enset.designpatterns.examenblanc.observer.Parametrage;

import java.io.Serializable;

public abstract class Figure implements Observer, Serializable {
    protected int epaisseurContour;
    protected int couleurContour;
    protected int couleurRemplissage;

    public abstract double calculerPerimetre();
    public abstract double calculerSurface();
    public abstract void dessiner();

    @Override
    public void update(Parametrage parametrage) {
        this.epaisseurContour = parametrage.getEpaisseurContour();
        this.couleurContour = parametrage.getCouleurContour();
        this.couleurRemplissage = parametrage.getCouleurRemplissage();
        System.out.println("Mise à jour des paramètres de la figure.");
    }
}
