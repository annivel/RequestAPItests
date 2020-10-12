package testsAPI;

import io.restassured.response.Response;
import models.Data;
import models.Employee;
import models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ReqresTests extends TestBase {

    @Test
    @DisplayName("Create user with valid info")
    void createUserWithInfo() {
        step("Verify that user is created with valid info", () -> {
            final Employee employee = new Employee() {{
                setName("Morpheus");
                setJob("Team-Lead");
            }};
            Response response = steps.createUserWithValidInfo(employee);
            response.then().statusCode(201)
                    .body("name", equalTo(employee.getName()))
                    .body("job", equalTo(employee.getJob()));
        });
    }

    @Test
    @DisplayName("Create new user without info")
    void createNewUser() {
        step("Verify that user is not created without email", () -> {
            final User invalidUser = new User() {{
                setEmail(null);
                setPassword(null);
            }};
            Response res = steps.createInvalidUser(invalidUser);
            res.then().statusCode(404);
        });
    }

    @Test
    @DisplayName("Register new user")
    void registerNewUser() {
        step("Registration of a new user", () -> {
            final User user = new User() {{
                setEmail("eve.holt@reqres.in");
                setPassword("pistol");
            }};

            Response response = steps.registerNewUser(user);
            response.then()
                    .statusCode(200)
                    .body("id", is(4));
        });
    }

    @Test
    @DisplayName("Find unregistered account")
    void findInvalidUserAccount() {
        step("Get invalid account", () -> {
            Response res = steps.getInvalidUserRequest(33);
            res.then().statusCode(404);
        });
    }

    @Test
    @DisplayName("Login with valid info")
    void loginValidUser() {
        step("Login user with valid info", () -> {
            final User user = new User();
            user.setEmail("eve.holt@reqres.in");
            user.setPassword("cityslicka");

            Response res = steps.loginUser(user);
            res.then().statusCode(200).body("token", is("QpwL5tke4Pnpja7X4"));
        });
    }

    @Test
    @DisplayName("Login without password")
    void loginWithoutPassword() {
        step("Login without password", () -> {
            final User user = new User();
            user.setEmail("eve.holt@reqres.in");

            Response res = steps.loginUser(user);
            res.then().statusCode(400)
                    .body("error", is("Missing password"));
        });
    }

    @Test
    @DisplayName("Find user by id")
    void getUserById() {
        step("Get user by id", () -> {
            step("Verify that email is valid ", () -> {
                Response res = steps.getUserById(4);
                Data data = res.then().extract().as(Data.class);
                assertThat(data.getData().getEmail(), is(equalTo("eve.holt@reqres.in")));
            });
        });
    }

    @Test
    @DisplayName("Updating by unregistered user")
    void updateUserAccount() {
        step("Put unregistered account", () -> {
            final User user = new User() {{
                setPassword("qwery1");
                setEmail("test@email.com");
            }};
            Response res = steps.updateUserRequest("987654", user);
            res.then().statusCode(404);
        });
    }

    @Test
    @DisplayName("Update of already created user")
    void updateAccount() {
        step("Update is already created user", () -> {
            final Employee employee = new Employee() {{
                setName("Morpheus");
                setJob("SMM manager");
            }};

            Response putRes = steps.updateEmployeeRequest(2, employee);
            putRes.then().statusCode(200);
        });
    }

    @Test
    @DisplayName("Delete user")
    void deleteUserRequest() {
        step("Delete registered user", () -> {
            Response res = steps.deleteUser(2);
            res.then().statusCode(204);

            Response getRes = steps.getUserById(2);
            getRes.then().statusCode(404);
        });
    }

}
