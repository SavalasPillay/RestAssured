package qot.tests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.omg.PortableInterceptor.SUCCESSFUL;
import static io.restassured.RestAssured.given;

public class PetsTest {

    static final ResponseSpecification success = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    static final RequestSpecification request = new RequestSpecBuilder()
            .setBaseUri("http://petstore.swagger.io/v2/pet")
            .build();

    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @ValueSource(strings = {"available","pending","sold"})
    public void testThatICanGetPetByStatus(String petStatus){
        //Response response =
        given()


        .spec(request)
                .when()
                .get("findByStatus?status=" + petStatus)
                .then()
                .spec(success);
        //int statuscode = response.getStatusCode();
        //Assert.assertEquals(statuscode, 400);



    }

}
