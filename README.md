# SignUpBook — a tiny TDD warm‑up

This project is a 5-10 minute exercise to show that **TDD is simple and quick** when done in small steps:

1) Start with **one failing test** that checks your name is registered.  
2) Make it **green** by adding your name to a JSON file.

---

## Prerequisites
- JDK 17+
- Gradle 8+ (or use the Gradle wrapper: `./gradlew` / `gradlew.bat`)

## Run the test suite
From the project root:
```bash
./gradlew -q test    # or: gradle -q test
```
You should see one failing test. Make it turn **green**.

---

## Your task: add yourself via TDD

### 1) Create a failing test (RED)
Open `src/test/java/.../SignUpBookTest.java` and add a method named:

```
<firstname>_<lastname>()
```

**Example (JUnit 5):**
```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class SignUpBookTest {

    @Test
    public void homer_simpson() throws IOException {
        String expected = "Homer Simpson";
        Assertions.assertTrue(registry.isRegistered(expected));
    }
}
```

> Keep it small: one assertion that expresses the behavior you want.

### 2) Make it pass (GREEN)
Add your name to the JSON file at:
```
src/main/resources/signUpNames.json
```

**Format (JSON array of strings):**
```json
[
  "Billie Holiday",
  "Homer Simpson"
]
```
- Put your full name exactly as your test expects (spacing/casing).
- Keep valid JSON (no trailing comma after the last item).

Run the tests again:
```bash
./gradlew -q test
```
Your new test should now be **green**.

### 3) (Optional) Refactor
No behavior changes—just tidy up if you see duplication.

---

## Why this demonstrates TDD
- You wrote a **failing test first** (red).
- You made the **smallest change** to pass (green).
- You can now **refactor safely** with tests watching your back.

---

## Troubleshooting
- **Wrong file path:** ensure the list lives at `src/main/resources/signUpNames.json`.
- **JSON syntax:** missing quotes or trailing commas will break loading.
- **Test method name:** use `<firstname>_<lastname>` to keep things consistent.
- **Registry wiring:** if `registry` is null, construct it in a `@BeforeEach` using your production class that loads `signUpNames.json`.

---

## Example snippets (for quick reference)

**Test**
```java
@Test
public void homer_simpson() throws IOException {
    String expected = "Homer Simpson";
    Assertions.assertTrue(registry.isRegistered(expected));
}
```

**names.json**
```json
[
  "Billie Holiday",
  "Homer Simpson"
]
```
