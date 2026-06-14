package ma.enset.designpatterns.examenblanc.strategy;

import ma.enset.designpatterns.examenblanc.model.Figure;
import java.util.List;

public class TraitementImpl1 implements TraitementStrategy {
    @Override
    public void traiter(List<Figure> figures) {
        System.out.println("Début du Traitement Algorithme 1 des figures du dessin...");
        for (Figure f : figures) {
            System.out.println("- Périmètre calculé: " + f.calculerPerimetre());
        }
        System.out.println("Fin du Traitement Algorithme 1.");
    }
}
