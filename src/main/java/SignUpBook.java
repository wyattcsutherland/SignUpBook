import java.io.IOException;

public class SignUpBook {
    private final NameRepository repository;

    public SignUpBook(NameRepository repository) {
        this.repository = repository;
    }

    public boolean isRegistered(String name) throws IOException {
        return repository.readNames().contains(name);
    }
}
