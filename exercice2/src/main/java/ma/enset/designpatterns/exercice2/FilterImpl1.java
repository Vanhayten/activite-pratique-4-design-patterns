package ma.enset.designpatterns.exercice2;

public class FilterImpl1 implements FilterStrategy {
    @Override
    public int[] filter(int[] data) {
        System.out.println("Application du Filtre Standard 1");
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] * 2; // Simulation d'un traitement
        }
        return result;
    }
}
