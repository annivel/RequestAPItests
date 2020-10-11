package testsAPI;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import models.Data;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ReqresTests extends TestBase {
    private int id;
    private String token;
    private User user;
    private Data data;

    @BeforeEach
    void beforeEach() {
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    @DisplayName("Create user with valid info")
    void createUserWithInfo() {
        step("Create user with valid info", () -> {
            steps.createUserWithValidInfo();
        });

    }

    @Test
    @DisplayName("Create new user without info")
    void createNewUser() {
        step("Create a new user", () -> {
            steps.createInvalidUser();
            assertThat(user.getEmail(), is(notNullValue()));
        });

    }

    @Test
    @DisplayName("Register new user")
    void registerNewUser() {
        step("Registration of a new user", () -> {
            step("Get id user", () -> {
                id = steps.registerNewUser();
            });
            step("Verify that id = 4", () -> {
                assertThat(id, is(4));
            });
        });

    }

    @Test
    @DisplayName("Find user by id")
    void getUserById() {
        step("Get user by id", () -> {
            step("Preparing data to sent ", () -> {
                steps.getUserById(4);
            });
        });

    }

    @Test
    @DisplayName("Find unregistered account")
    void findInvalidUserAccount() {
        step("Get invalid account", () -> {
            steps.getInvalidUserRequest(33);
        });

    }

    @Test
    @DisplayName("Login with valid info")
    void loginUser() {
        step("Login user with valid info", () -> {
            step("Get user's token", () -> {
                token = steps.setLoginUser();
            });
            step("Verify that token equals to QpwL5tke4Pnpja7X4", () -> {
                assertThat(token, is("QpwL5tke4Pnpja7X4"));
            });
        });

    }

    @Test
    @DisplayName("Login without password")
    void login() {
        step("Login without password", () -> {
            steps.loginWithoutPassword("peter@klaven");
        });

    }

    @Test
    @DisplayName("Updating by unregistered user")
    void updateUserAccount() {
        step("Put unregistered account", () -> {
            steps.updateRequest("ab987654");
        });

    }

    @Test
    @DisplayName("Update is already created user")
    void updateAccount() {
        step("Update is already created user", () -> {
            steps.updateAccountRequest();
        });

    }


    @Test
    @DisplayName("Delete user")
    void deleteUserRequest() {
        step("Delete registered user", () -> {
            steps.deleteUser(2);
        });
    }

}
