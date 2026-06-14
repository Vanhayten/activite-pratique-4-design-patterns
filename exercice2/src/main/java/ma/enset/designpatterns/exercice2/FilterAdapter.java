package ma.enset.designpatterns.exercice2;

public class FilterAdapter implements FilterStrategy {
    private ImplNonStandard oldImpl;
    private String filterName;

    public FilterAdapter(ImplNonStandard oldImpl, String filterName) {
        this.oldImpl = oldImpl;
        this.filterName = filterName;
    }

    @Override
    public int[] filter(int[] data) {
        return oldImpl.appliquerFiltre(filterName, data);
    }
}
