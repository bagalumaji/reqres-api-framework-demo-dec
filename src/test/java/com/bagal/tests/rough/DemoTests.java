package com.bagal.tests.rough;

import com.bagal.models.request.user.CreateUserRequestPoJo;
import com.bagal.models.response.user.CreateUserResponsePojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static com.bagal.configs.PropertyConfig.getValue;
import static io.restassured.RestAssured.given;

public class DemoTests {
    @Test
    public void demoTest() throws JsonProcessingException {
        CreateUserRequestPoJo userPoJo = CreateUserRequestPoJo.builder().
                setName("sayaji").setJob("dev").build();
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writeValueAsString(userPoJo);
        Response response = given()
                .body(body)
                .baseUri(getValue("base.uri"))
                .basePath(getValue("base.path.user"))
                .contentType(ContentType.JSON)
                .when()
                .post();
        String resBody = response.body().asString();

        CreateUserResponsePojo userResponsePojo = mapper.readValue(resBody, CreateUserResponsePojo.class);
        System.out.println("userResponsePojo.getCreatedAt() = " + userResponsePojo.getCreatedAt());
        System.out.println("userResponsePojo.getId() = " + userResponsePojo.getId());
        System.out.println("userResponsePojo.getName() = " + userResponsePojo.getName());
        System.out.println("userResponsePojo.getJob() = " + userResponsePojo.getJob());
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/sayajirajebagal/repos/reqres-api-framework-demo-dec/src/test/resources/schema/CreateUserSchema.json")));
    }

    @Test(dataProvider = "getData")
    public void readJsonTest(Object[] data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CreateUserRequestPoJo createUserRequestPoJo = mapper.readValue(data[0].toString(), CreateUserRequestPoJo.class);
        System.out.println("createUserRequestPoJo.getName() = " + createUserRequestPoJo.getName());
        System.out.println("createUserRequestPoJo.getJob() = " + createUserRequestPoJo.getJob());

    }

    @DataProvider
    public Object[] getData() throws JsonProcessingException {

        CreateUserRequestPoJo userPoJo = CreateUserRequestPoJo.builder().setName("sayaji").setJob("dev").build();
        Object[] data = new Object[1];
        ObjectMapper mapper = new ObjectMapper();
        String createUserRequestPoJo = mapper.writeValueAsString(userPoJo);
        data[0] = createUserRequestPoJo;
        return data;
    }
}
