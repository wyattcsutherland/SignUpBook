import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JsonNameRepository implements NameRepository {
    private static final ObjectMapper mapper = new ObjectMapper();
    private final File file = new File("src/main/resources/signUpNames.json");

    @Override
    public List<String> readNames() throws IOException {
        return mapper.readValue(file, new TypeReference<List<String>>() {});
    }

    @Override
    public void addName(String name) throws IOException {
        List<String> names = readNames();
        names.add(name);
        writeNames(names);
    }

    @Override
    public void writeNames(List<String> names) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, names);
    }

    @Override
    public void clearNames() throws IOException {
        List<String> emptyList = Collections.emptyList();
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, emptyList);
    }

}

