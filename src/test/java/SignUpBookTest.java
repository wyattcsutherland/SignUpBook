import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SignUpBookTest {
    static SignUpBook registry;

    @BeforeAll
    static void initAll() {
        registry = new SignUpBook(new JsonNameRepository());
    }

    @Test
    public void billie_holiday() throws IOException {
        String expected = "Billie Holiday";
        Assertions.assertTrue(registry.isRegistered(expected));
    }

    @Test
    public void homer_simpson() throws IOException {
        String expected = "Homer Simpson";
        Assertions.assertTrue(registry.isRegistered(expected));
    }

    @Test
    public void steve_fraser() throws IOException {
        String expected = "Steve Fraser";
        Assertions.assertTrue(registry.isRegistered(expected));
    }

    /*===========================================
        This test ensures that every name listed in signUpNames.json has a corresponding test method
     ============================================*/
    @Test
    public void every_name_in_json_should_start_with_a_test_first() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<String> names = mapper.readValue(new File("src/main/resources/signUpNames.json"), new TypeReference<List<String>>() {});

        List<String> testMethodNames = Arrays.stream(SignUpBookTest.class.getDeclaredMethods())
                .map(Method::getName)
                .collect(Collectors.toList());

        List<String> missingTests = names.stream()
                .filter(name -> {
                    String expectedMethod = name.toLowerCase().replace(" ", "_");
                    return testMethodNames.stream().noneMatch(m -> m.toLowerCase().contains(expectedMethod));
                })
                .collect(Collectors.toList());

        Assertions.assertTrue(
                missingTests.isEmpty(),
                "The following names in signUpNames.json do not have a corresponding test: " + missingTests
        );
    }
}