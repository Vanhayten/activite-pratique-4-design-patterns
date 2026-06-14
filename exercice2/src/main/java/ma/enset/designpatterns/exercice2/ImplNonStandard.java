package ma.enset.designpatterns.exercice2;

public class ImplNonStandard {
    public int[] appliquerFiltre(String filterName, int[] data) {
        System.out.println("Application du filtre non standard : " + filterName);
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] + 10; // Simulation d'un traitement
        }
        return result;
    }
}
