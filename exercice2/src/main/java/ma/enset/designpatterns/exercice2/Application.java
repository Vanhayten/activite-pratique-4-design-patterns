package ma.enset.designpatterns.exercice2;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FrameworkImage imageProcessor = new MyFrameworkImage();
        int[] imageData = {10, 20, 30, 40, 50};

        System.out.println("Veuillez saisir le nom complet de la classe du filtre (ex: ma.enset.designpatterns.exercice2.FilterImpl1) ou 'adapter' pour l'ancienne implémentation:");
        String className = scanner.nextLine();

        FilterStrategy strategy;

        if (className.equalsIgnoreCase("adapter")) {
            System.out.println("Saisissez le nom du filtre pour l'ancienne implémentation :");
            String filterName = scanner.nextLine();
            strategy = new FilterAdapter(new ImplNonStandard(), filterName);
        } else {
            // Instanciation dynamique
            strategy = (FilterStrategy) Class.forName(className).getDeclaredConstructor().newInstance();
        }

        imageProcessor.setFilterStrategy(strategy);
        
        System.out.println("\n--- Exécution du Filtrage ---");
        int[] filteredData = imageProcessor.filter(imageData);
        for (int val : filteredData) {
            System.out.print(val + " ");
        }
        System.out.println("\n");

        System.out.println("--- Exécution de la Compression ---");
        int[] compressedData = imageProcessor.compresser(filteredData);
        for (int val : compressedData) {
            System.out.print(val + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
