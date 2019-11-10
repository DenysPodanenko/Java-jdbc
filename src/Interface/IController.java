package Interface;

import java.util.ArrayList;

public interface IController<T> {
    public ArrayList<T> getAllObjects();
    public Boolean addObject(T object);
    public void updateObject();
    public T getObjectById(Integer id);
}
