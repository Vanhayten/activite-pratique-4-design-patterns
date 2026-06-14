package ma.enset.designpatterns.exercice2;

public class MyFrameworkImage extends FrameworkImage {
    @Override
    protected int[] doCompress(int[] data) {
        System.out.println("Exécution de l'algorithme spécifique de compression.");
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] / 2; // Simulation de compression
        }
        return result;
    }
}
