package ma.enset.designpatterns.exercice2;

public abstract class FrameworkImage {
    private FilterStrategy filterStrategy;

    public void setFilterStrategy(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    // Opération de filtrage déléguée à la stratégie
    public int[] filter(int[] data) {
        if (filterStrategy == null) {
            System.out.println("Aucune stratégie de filtrage définie, retour des données originales.");
            return data;
        }
        return filterStrategy.filter(data);
    }

    // Squelette de l'algorithme de compression (Template Method)
    public int[] compresser(int[] data) {
        System.out.println("Début de la compression...");
        int[] preProcessed = preProcess(data);
        int[] compressed = doCompress(preProcessed);
        int[] postProcessed = postProcess(compressed);
        System.out.println("Fin de la compression.");
        return postProcessed;
    }

    // Etapes de la Template Method
    protected int[] preProcess(int[] data) {
        System.out.println("Prétraitement par défaut avant compression.");
        return data;
    }

    protected abstract int[] doCompress(int[] data);

    protected int[] postProcess(int[] data) {
        System.out.println("Post-traitement par défaut après compression.");
        return data;
    }
}
