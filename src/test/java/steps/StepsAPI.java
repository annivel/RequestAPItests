package steps;

import helpers.Request;
import io.restassured.response.Response;
import models.Employee;
import models.User;

import static io.restassured.RestAssured.given;

public class StepsAPI {

    public Response registerNewUser(User user) {
        return given()
                .spec(Request.spec())
                .body(user)
                .log().uri()
                .log().body()
                .when()
                .post("/register");
    }

    public Response getInvalidUserRequest(final int id) {
        return given()
                .spec(Request.spec())
                .when()
                .get("/users/{id}", id);
    }

    public Response loginUser(User user) {
        return given()
                .spec(Request.spec())
                .body(user)
                .log().uri()
                .log().body()
                .when()
                .post("/login");
    }

    public Response updateUserRequest(final String id, final User user) {
        return given()
                .spec(Request.spec()).body(user)
                .log().uri()
                .log().body()
                .when()
                .put("/users/{id}", id);
    }

    public Response createInvalidUser(User user) {
        return given()
                .spec(Request.spec())
                .body(user)
                .log().uri()
                .log().body()
                .when()
                .post("/users");
    }

    public Response createUserWithValidInfo(Employee employee) {
        return given()
                .spec(Request.spec())
                .body(employee)
                .log().uri()
                .log().body()
                .when()
                .post("/users");
    }


    public Response updateEmployeeRequest(final int id, Employee employee) {
        return given()
                .spec(Request.spec())
                .body(employee)
                .when()
                .put("/users/{id}", id);
    }

    public Response getUserById(final int id) {
        return given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .get("/users/{id}", id);
    }

    public Response deleteUser(final int id) {
        return given()
                .spec(Request.spec())
                .log().uri()
                .when()
                .delete("/users/{id}", id);
    }

}
