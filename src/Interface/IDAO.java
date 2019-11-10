package Interface;

import java.util.ArrayList;

public interface IDAO<T> {
    public ArrayList<T> getObject();
    public Boolean addObject(T object);
}
