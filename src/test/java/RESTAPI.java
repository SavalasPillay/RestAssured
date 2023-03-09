import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;

@Epic("REST API Regression Testing using JUnit4")
@Feature("Verify CRUID Operations on Employee module")
public class RESTAPI {

    String BaseURL = "http://petstore.swagger.io/v2/pet";

    @Test

    @Description("Test Description : Verify the details of the pet status")
    public void verifyPetUser() {

        // Given
        given()
                .filter(new AllureRestAssured())

                // WHEN
                .when()
                .get(BaseURL + "v2/pet/findByStatus?status")

                // THEN
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                // To verify booking id at index 2
                .body("data.employee_name", (ResponseAwareMatcher<Response>) equalTo(""))
                .body("message", (ResponseAwareMatcher<Response>) equalTo("Successfully! Record has been fetched."));
    }

    @Test
    @Story("POST Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the creation of a new employee")
    public void createUser() {

        JSONObject data = new JSONObject();

        // Map<String, String> map = new HashMap<String, String>();

        data.put("employee_name", "APITest");
        data.put("employee_salary", "99999");
        data.put("employee_age", "30");

        // GIVEN
        given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(data.toString())

                // WHEN
                .when()
                .post(BaseURL + "/v1/create")

                // THEN
                .then()
                .statusCode(200)
                .body("data.employee_name", (ResponseAwareMatcher<Response>) equalTo("APITest"))
                .body("message", (ResponseAwareMatcher<Response>) equalTo("Successfully! Record has been added."));

    }

}