package ma.enset.designpatterns.examenblanc.app;

import ma.enset.designpatterns.examenblanc.model.*;
import ma.enset.designpatterns.examenblanc.observer.Parametrage;
import ma.enset.designpatterns.examenblanc.security.SecurityContext;
import ma.enset.designpatterns.examenblanc.strategy.TraitementImpl1;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Authentification GUEST ---");
        SecurityContext.authenticate("guest", "GUEST");

        // 1. Création du paramétrage (Sujet)
        Parametrage parametrage = new Parametrage();

        // 2. Création des figures
        Cercle c1 = new Cercle(new Point(10, 10), 5);
        Rectangle r1 = new Rectangle(new Point(0, 0), 20, 10);
        
        GroupeFigures groupe = new GroupeFigures();
        groupe.ajouterFigure(new Cercle(new Point(50, 50), 15));
        groupe.ajouterFigure(new Rectangle(new Point(30, 30), 40, 20));

        // 3. Enregistrement des figures comme observateurs du paramétrage
        parametrage.addObserver(c1);
        parametrage.addObserver(r1);
        parametrage.addObserver(groupe);

        // 4. Création du dessin et ajout des figures
        Dessin dessin = new Dessin();
        
        System.out.println("\n--- Tentative d'ajout de figures (GUEST) ---");
        dessin.ajouterFigure(c1); // Devrait être bloqué par l'aspect Security
        
        System.out.println("\n--- Authentification ADMIN ---");
        SecurityContext.authenticate("admin", "ADMIN");
        System.out.println("--- Nouvelle tentative d'ajout de figures (ADMIN) ---");
        dessin.ajouterFigure(c1);
        dessin.ajouterFigure(r1);
        dessin.ajouterFigure(groupe);

        // 5. Affichage initial
        System.out.println("--- Avant changement de paramétrage ---");
        dessin.afficherDessin();

        // 6. Changement du paramétrage (doit notifier les figures)
        System.out.println("\n--- Changement de paramétrage ---");
        parametrage.setParametres(3, 0xFF0000, 0x00FF00); // Ex: contour rouge, remplissage vert

        // 7. Affichage après changement
        System.out.println("\n--- Après changement de paramétrage ---");
        dessin.afficherDessin();

        // 8. Test de la stratégie de traitement
        System.out.println("\n--- Test du Traitement (Stratégie) ---");
        dessin.setTraitementStrategy(new TraitementImpl1());
        dessin.traiter();

        // 9. Sérialisation
        System.out.println("\n--- Test de la Sérialisation ---");
        String filename = "dessin.dat";
        dessin.serialiser(filename);

        // 10. Désérialisation
        System.out.println("\n--- Test de la Désérialisation ---");
        Dessin dessinDeserialise = Dessin.deserialiser(filename);
        if (dessinDeserialise != null) {
            dessinDeserialise.afficherDessin();
        }
    }
}
