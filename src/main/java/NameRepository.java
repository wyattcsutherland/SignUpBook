import java.io.IOException;
import java.util.List;

public interface NameRepository {
    void addName(String name) throws IOException;
    List<String> readNames() throws IOException;
    void writeNames(List<String> names) throws IOException;
    void clearNames() throws IOException;
}
