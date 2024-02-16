import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class answer_api_test {
    @Test
    @Description("проверка содержимого ответа в тесте")
    @Epic(value = "тесты api")
    @Feature(value = "проверки содержимого")
    @Story(value = "проверка кода ответа")
        public void test(){
        System.out.println("sdfvsdf");

        String answer = String.valueOf(given()
                .filter(new AllureRestAssured())
                .log().all()
                .header("Autorisation","Bearer")
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/user?page=2")
                .prettyPeek()
                .then()

                        .extract().jsonPath().getString("data[1].id")

                );
        Assert.assertEquals(answer,"8","несовпадает");


    }
}
