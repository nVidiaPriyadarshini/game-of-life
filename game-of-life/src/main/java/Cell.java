import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

@Getter
@Setter
public class Cell<T, U, V> implements Serializable {

    private final T rowPosition;
    private final U colPosition;
    private V cellState;

    public Cell(T rowPosition, U colPosition, V cellState) {
        this.rowPosition = rowPosition;
        this.colPosition = colPosition;
        this.cellState = cellState;
    }

    @Override
    public Cell clone() {
        Cell copyOfCell = SerializationUtils.clone(this);
        return copyOfCell;
    }

}
