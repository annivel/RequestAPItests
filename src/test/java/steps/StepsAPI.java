package steps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.AccountIfo;
import models.User;
import spec.Request;

import static io.restassured.RestAssured.given;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StepsAPI {
    public int registerNewUser() {
        final User createUser = new User();
        createUser.setEmail("eve.holt@reqres.in");
        createUser.setPassword("pistol");
        return given()
                .spec(Request.spec())
                .body(createUser)
                .log().uri()
                .log().body()
                .when()
                .post("/register")
                .then()
                .log().body()
                .extract()
                .path("id");
    }

    public void getInvalidUserRequest(final int id) {
        given()
                .spec(Request.spec())
                .when()
                .get("/users/{id}", id)
                .then()
                .statusCode(404);

    }

    public String setLoginUser() {
        final User loginUser = new User();
        loginUser.setEmail("eve.holt@reqres.in");
        loginUser.setPassword("cityslicka");
        return given()
                .spec(Request.spec())
                .body(loginUser)
                .log().uri()
                .log().body()
                .when()
                .post("/login")
                .then()
                .log().body()
                .extract()
                .path("token");
    }

    public void updateRequest(final String id) {
        final User user = new User();
        user.setPassword("qwery1");
        given()
                .spec(Request.spec()).body(user)
                .log().uri()
                .log().body()
                .when()
                .put("/users/{id}", id)
                .then()
                .statusCode(404);
    }

    public void createInvalidUser() {
        final User createUser = new User();
        createUser.setEmail(null);
        createUser.setPassword(null);
        given()
                .spec(Request.spec())
                .body(createUser)
                .log().uri()
                .log().body()
                .when()
                .post("/users")
                .then()
                .log().body().statusCode(404);

    }

    public void createUserWithValidInfo() {
        final AccountIfo createUser = new AccountIfo();
        createUser.setName("Morpheus");
        createUser.setJob("Team-Lead");
        given()
                .spec(Request.spec())
                .body(createUser)
                .log().uri()
                .log().body()
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }


    public void updateAccountRequest() {
        final AccountIfo accountIfo = new AccountIfo();
        accountIfo.setName("Morpheus");
        accountIfo.setJob("SMM manager");
        given()
                .spec(Request.spec())
                .body(accountIfo)
                .when()
                .put("/users/2")
                .then()
                .log().body().statusCode(200);

    }

    public void getUserById(final int id) {
        given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .get("/users/{id}", id)
                .then()
                .log().body().statusCode(200);

    }

    public void deleteUser(final int id) {
        given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .delete("/users/{id}", id)
                .then()
                .statusCode(204);


    }

    public void loginWithoutPassword(String email) {
        final User userLogin = new User();
        userLogin.setEmail(email);
        given()
                .spec(Request.spec())
                .body(userLogin)
                .when()
                .post("/login")
                .then()
                .log().body().statusCode(400);

    }
}
