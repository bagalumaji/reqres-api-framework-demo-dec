package com.bagal.tests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.bagal.configs.PropertyConfig.getValue;
import static io.restassured.RestAssured.given;

public class GetUserTests {

    @Test
    public void getSingleUserTest(){
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        int statusCode = response.statusCode();
        System.out.println("status code : "+statusCode);
        System.out.println("status Line ==> "+response.statusLine());
        System.out.println(response.header("content-Type"));
        System.out.println("response.header(\"content-Type\") = " + response.header("content-Type"));
        System.out.println("response.body().jsonPath().getInt(\"data.id\") = " + response.body().jsonPath().getInt("data.id"));
    }
    @Test
    public void getSingleUserTest1(){
        Response response = given()
                .baseUri(getValue("base.uri"))
                .basePath(getValue("base.path.user"))
                .log()
                .all()
                .when()
                .get(getValue("user.id"));
        response.prettyPrint();
    }
}
