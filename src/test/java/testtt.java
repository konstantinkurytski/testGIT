import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testtt {
    @Test
    public void testttt(){
        System.out.println("sdfvsdf");

        given()
                .filter(new AllureRestAssured())
                .log().all()
                .header("Autorisation","Bearer")
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/user?page=2")
                .prettyPeek()
                .then()
                .statusCode(222);

    }
}
