package ma.enset.designpatterns.examenblanc.model;

public class Cercle extends Figure {
    private Point centre;
    private double rayon;

    public Cercle(Point centre, double rayon) {
        this.centre = centre;
        this.rayon = rayon;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * Math.PI * rayon;
    }

    @Override
    public double calculerSurface() {
        return Math.PI * Math.pow(rayon, 2);
    }

    @Override
    public void dessiner() {
        System.out.println("Dessin d'un Cercle de centre (" + centre.getX() + "," + centre.getY() + 
                ") et de rayon " + rayon + " | Epaisseur: " + epaisseurContour + 
                ", Couleur Contour: " + couleurContour + ", Remplissage: " + couleurRemplissage);
    }
}
