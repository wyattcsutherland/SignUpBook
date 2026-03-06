import org.junit.jupiter.api.*;
import java.io.IOException;

public class JsonNameRepositoryTest {

    static JsonNameRepository json;

    @BeforeAll
    public static void setup() throws IOException {
        json = new JsonNameRepository();
    }

    @AfterAll
    public static void cleanUp() throws IOException {
        json.clearNames();
    }

    @Test
    public void add_one_name() throws Exception {
        json.clearNames();
        json.addName("Billie Holiday");
        Assertions.assertEquals(1, json.readNames().size());
    }

    @Test
    public void add_two_names() throws Exception {
        json.clearNames();
        json.addName("Homer Simpson");
        json.addName("Mark Twain");
        Assertions.assertEquals(2, json.readNames().size());
    }
}
