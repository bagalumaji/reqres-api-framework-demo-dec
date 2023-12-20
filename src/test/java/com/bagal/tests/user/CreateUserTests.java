package com.bagal.tests.user;

import com.bagal.models.request.user.CreateUserRequestPoJo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.bagal.configs.PropertyConfig.getValue;
import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void createUserDemo1Test(){
        String payload = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response = given()
                .baseUri(getValue("base.uri"))
                .basePath(getValue("base.path.user"))
                .body(payload)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .post();

        response.prettyPrint();
    }

    @Test
    public void createUserDemo2Test(){
        Response response = given()
                .baseUri(getValue("base.uri"))
                .basePath(getValue("base.path.user"))
                .body(new File(System.getProperty("user.dir")+"/src/test/resources/testdata/CreateUserJsonData.json"))
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .post();

        response.prettyPrint();
    }

    // here we need a serializer to transfer a java object
    @Test
    public void createUserDemo3Test(){
        Map<String,String> payload = new HashMap<>();
        payload.put("name","sharu");
        payload.put("job","dev");
        Response response = given()
                .baseUri(getValue("base.uri"))
                .basePath(getValue("base.path.user"))
                .body(payload)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .post();

        response.prettyPrint();
    }
    @Test
    public void createUserDemo4Test(){
        JSONObject payload = new JSONObject();
        payload.put("name","Sharannya");
        payload.put("job","QA");
        Response response = given()
                .baseUri(getValue("base.uri"))
                .basePath(getValue("base.path.user"))
                .body(payload.toString())
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .post();

        response.prettyPrint();
    }

    @Test
    public void createUserDemo5Test(){
        CreateUserRequestPoJo userPoJo = CreateUserRequestPoJo.builder().name("sayaji").job("dev").build();
        Response response = given()
                .baseUri(getValue("base.uri"))
                .basePath(getValue("base.path.user"))
                .body(userPoJo)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .post();

        response.prettyPrint();
    }

}
