package com.bagal.tests.rough;

import com.bagal.models.request.user.CreateUserRequestPoJo;
import com.bagal.models.response.user.CreateUserResponsePojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.bagal.configs.PropertyConfig.getValue;
import static io.restassured.RestAssured.given;

public class DemoTests {
    @Test
    public void demoTest() throws JsonProcessingException {
        CreateUserRequestPoJo userPoJo = CreateUserRequestPoJo.builder().name("sayaji").job("dev").build();
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
    }

}
