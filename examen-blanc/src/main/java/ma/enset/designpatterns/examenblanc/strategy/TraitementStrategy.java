package ma.enset.designpatterns.examenblanc.strategy;

import ma.enset.designpatterns.examenblanc.model.Figure;
import java.util.List;

public interface TraitementStrategy {
    void traiter(List<Figure> figures);
}
