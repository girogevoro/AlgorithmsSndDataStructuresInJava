import java.util.Comparator;

public class NotebookCompare implements Comparator<Notebook> {

    @Override
    public int compare(Notebook o1, Notebook o2) {
        return Comparator.comparing(Notebook::getPrice)
                .thenComparing(Notebook::getRam)
                .thenComparing(Notebook::getBrand).compare(o1,o2);
    }
}
