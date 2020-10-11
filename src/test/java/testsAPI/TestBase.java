package testsAPI;

import org.junit.jupiter.api.BeforeAll;
import steps.StepsAPI;

public class TestBase {
    static StepsAPI steps;

    @BeforeAll
    public static void init() {
        steps = new StepsAPI();
    }
}
