package ma.enset.designpatterns.examenblanc.model;

import ma.enset.designpatterns.examenblanc.observer.Parametrage;

import java.util.ArrayList;
import java.util.List;

public class GroupeFigures extends Figure {
    private List<Figure> figures = new ArrayList<>();

    public void ajouterFigure(Figure f) {
        figures.add(f);
    }

    public void supprimerFigure(Figure f) {
        figures.remove(f);
    }

    @Override
    public double calculerPerimetre() {
        double total = 0;
        for (Figure f : figures) {
            total += f.calculerPerimetre();
        }
        return total;
    }

    @Override
    public double calculerSurface() {
        double total = 0;
        for (Figure f : figures) {
            total += f.calculerSurface();
        }
        return total;
    }

    @Override
    public void dessiner() {
        System.out.println("Début du dessin du groupe :");
        for (Figure f : figures) {
            f.dessiner();
        }
        System.out.println("Fin du dessin du groupe.");
    }

    @Override
    public void update(Parametrage parametrage) {
        super.update(parametrage);
        for (Figure f : figures) {
            f.update(parametrage);
        }
    }
}
