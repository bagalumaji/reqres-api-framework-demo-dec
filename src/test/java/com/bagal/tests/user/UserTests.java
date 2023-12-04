package com.bagal.tests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserTests {

    @Test
    public void getSingleUserTest(){
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        int statusCode = response.statusCode();

        System.out.println("status code : "+statusCode);
        System.out.println("status Line ==> "+response.statusLine());
        System.out.println(response.header("content-Type"));
        System.out.println("response.header(\"content-Type\") = " + response.header("content-Type"));
        System.out.println("response.body().jsonPath().getInt(\"data.id\") = " + response.body().jsonPath().getInt("data.id"));
        //response.prettyPrint();
    }
}
