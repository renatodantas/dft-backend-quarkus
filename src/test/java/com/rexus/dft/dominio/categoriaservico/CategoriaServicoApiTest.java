package com.rexus.dft.dominio.categoriaservico;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CategoriaServicoApiTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/api/categorias")
                .then()
                .statusCode(200)
                .body(CoreMatchers.is("hello"));
    }
}