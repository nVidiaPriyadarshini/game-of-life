import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell<T,U,V> {

    private final T rowPosition;
    private final U colPosition;
    private final V cellState;

    public Cell(T rowPosition, U colPosition, V cellState) {
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
        this.cellState = cellState;
    }

}
