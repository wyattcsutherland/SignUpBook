import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

public class JsonNameRepositoryTest {

    JsonNameRepository json;

    @Disabled
    @BeforeEach
    public void setup() {
        json = new JsonNameRepository();
    }

    @Disabled
    public void read_names_from_json() throws Exception {
        json.clearNames();
        Assertions.assertEquals(0, json.readNames().size());
    }

    @Disabled
    public void add_one_name_to_json() throws Exception {
        json.clearNames();
        json.addName("Billy Holiday");
        Assertions.assertEquals(1, json.readNames().size());
    }

    @Disabled
    public void add_two_name_to_json() throws Exception {
        json.clearNames();
        json.addName("Billy Holiday");
        json.addName("Jesse James");
        Assertions.assertEquals(2, json.readNames().size());
    }

}
