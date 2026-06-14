package ma.enset.designpatterns.examenblanc.observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Parametrage implements Observable, Serializable {
    private int epaisseurContour;
    private int couleurContour;
    private int couleurRemplissage;
    
    private transient List<Observer> observers = new ArrayList<>();

    public Parametrage() {
        this.epaisseurContour = 1;
        this.couleurContour = 0; // Black
        this.couleurRemplissage = 0xFFFFFF; // White
    }

    public void setParametres(int epaisseurContour, int couleurContour, int couleurRemplissage) {
        this.epaisseurContour = epaisseurContour;
        this.couleurContour = couleurContour;
        this.couleurRemplissage = couleurRemplissage;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        if (observers == null) observers = new ArrayList<>();
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers != null) observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        if (observers != null) {
            for (Observer o : observers) {
                o.update(this);
            }
        }
    }
    
    public int getEpaisseurContour() { return epaisseurContour; }
    public int getCouleurContour() { return couleurContour; }
    public int getCouleurRemplissage() { return couleurRemplissage; }
}
