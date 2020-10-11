package testsAPI;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import steps.StepsAPI;

public class TestBase {
    static StepsAPI steps;

    @BeforeAll
    public static void init() {
        steps = new StepsAPI();
        RestAssured.filters(new AllureRestAssured());
    }

}
