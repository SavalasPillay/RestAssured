import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ResponseStatus {

    @Test
    public void testThatICanGetPetByStatus() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://petstore.swagger.io/v2/pet/findByStatus/Available";
        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("");

        // Get the status code of the request.
        //If request is successful, status code will be 200
        int statusCode = response.getStatusCode();

        // Assert that correct status code is returned.

    }
}
