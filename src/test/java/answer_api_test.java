import common.list;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class answer_api_test {

        @Test
        @Description("проверка содержимого ответа в тесте")
        @Epic(value = "тесты api")
        @Feature(value = "проверки содержимого")
        @Story(value = "проверка int")
        public void test_str1() {
            List<String> list = given()
                    .filter(new AllureRestAssured())
                    .contentType(ContentType.JSON)
                    .log().all()
                    .when().get("https://reqres.in/api/users")
                    .prettyPeek()
                    .then()
                    .statusCode(200)
                    .extract().jsonPath().getList("data.id");
            Assert.assertEquals(list.get(0), 1,"sdcfvs");


    }
    @Test
    @Description("проверка содержимого ответа в тесте")
    @Epic(value = "тесты api")
    @Feature(value = "проверки содержимого")
    @Story(value = "проверка int")
    public void test_str() {
        List<String> list2 = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .log().all()
                .when().get("https://reqres.in/api/users")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data.id");
        Assert.assertEquals(list2.get(1), 2,"sdcfvs");
        Assert.assertEquals(list2.get(2), 3,"sdcfvs");

    }
}
