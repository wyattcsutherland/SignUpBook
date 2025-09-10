import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SignUpBookTest {
    static SignUpBook registry;

    @BeforeAll
    static void initAll() {
        registry = new SignUpBook(new JsonNameRepository());
    }

    @Test
    public void sign_up_billie_holiday() throws IOException {
        String expected = "Billie Holiday";
        //assertion fails, add your name to names.json
        Assertions.assertTrue(registry.isRegistered(expected));
    }

    @Test
    public void sign_up_homer_simpson() throws IOException {
        String expected = "Homer Simpson";
        //assertion fails, add your name to names.json
        Assertions.assertTrue(registry.isRegistered(expected));
    }

    @Test
    public void sign_up_steve_fraser() throws IOException {
        String expected = "Steve Fraser";
        //assertion fails, add your name to names.json
        Assertions.assertTrue(registry.isRegistered(expected));
    }
}