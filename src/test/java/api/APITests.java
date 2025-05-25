package api;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Tag("api")
public class APITests {

    @Test
    @Description("API Test Example - Get Users")
    void testGetUsers() {
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}
