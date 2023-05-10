import java.util.ArrayList;

public interface IDataAccess {
    Object getByID(int id);
    void deleteByID(int id);
    void add(Object object);
    ArrayList getALL();
    void fileUpdater();
}