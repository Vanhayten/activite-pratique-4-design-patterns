package ma.enset.designpatterns.examenblanc.model;

public class Rectangle extends Figure {
    private Point coinSuperieurGauche;
    private double largeur;
    private double hauteur;

    public Rectangle(Point coinSuperieurGauche, double largeur, double hauteur) {
        this.coinSuperieurGauche = coinSuperieurGauche;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * (largeur + hauteur);
    }

    @Override
    public double calculerSurface() {
        return largeur * hauteur;
    }

    @Override
    public void dessiner() {
        System.out.println("Dessin d'un Rectangle au point (" + coinSuperieurGauche.getX() + "," + coinSuperieurGauche.getY() + 
                ") de largeur " + largeur + " et hauteur " + hauteur + 
                " | Epaisseur: " + epaisseurContour + ", Couleur Contour: " + couleurContour + ", Remplissage: " + couleurRemplissage);
    }
}
