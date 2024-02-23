import common.listPojo;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.assertj.core.api.AbstractListAssert;
import org.assertj.core.api.ObjectAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class answer_api_test {

    @Test
    @Description("проверка содержимого ответа в тесте")
    @Epic(value = "тесты api")
    @Feature(value = "проверки содержимого")
    @Story(value = "проверка int")
    public void test_str1() {
        Integer list = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .log().all()
                .when().get("https://reqres.in/api/users")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract().jsonPath().getInt("data[0].id");
        Assert.assertEquals(list, 1, "sdcfvs");


    }

    @Test
    @Description("проверка содержимого ответа в тесте")
    @Epic(value = "тесты api")
    @Feature(value = "проверки содержимого")
    @Story(value = "проверка list")
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
        Assert.assertEquals(list2.get(1), 2, "sdcfvs");
        Assert.assertEquals(list2.get(2), 3, "sdcfvs");

    }

    @Test
    @Description("проверка содержимого ответа в тесте")
    @Epic(value = "тесты api")
    @Feature(value = "проверки содержимого")
    @Story(value = "проверка extract")
    public void test_str3() {
        Integer list2 = Math.toIntExact(given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .log().all()
                .when().get("https://reqres.in/api/users")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract().time());
        System.out.println(list2);
        Assert.assertNotEquals(list2,2,"sdc");

    }
    @Test
    @Description("проверка содержимого ответа в тесте")
    @Epic(value = "тесты api")
    @Feature(value = "проверки содержимого")
    @Story(value = "проверка extract")
    public void test_str4() {
        List<listPojo> list3 = given()
                .contentType(ContentType.JSON)
                .log().all()
                .when().get("https://reqres.in/api/users")
                .prettyPeek()
                .then()

                .extract().jsonPath().getList("data", listPojo.class);
        Assert.assertEquals(list3.get(1).id,2);
    }
}