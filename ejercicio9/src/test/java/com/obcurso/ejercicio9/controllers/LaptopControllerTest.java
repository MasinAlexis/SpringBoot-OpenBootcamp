package com.obcurso.ejercicio9.controllers;

import com.obcurso.ejercicio9.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void create() {
        //Con esto indicamos que se va a enviar datos en formato JSON
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                    {
                        "marca": "DellTest",
                        "modelo": "InspironTest",
                        "memDisco": 1000,
                        "memRam": 16,
                        "microprocesador": "Intel I7 Test"
                    }
                    """;
        //Creamos la request, similar a lo que hacemos desdes Postman
        HttpEntity<String> request = new HttpEntity<>(json, header);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/guardarLaptop", HttpMethod.POST, request, Laptop.class);

        Laptop result = response.getBody();
        assertEquals("DellTest", result.getMarca());
        assertEquals("InspironTest", result.getModelo());
        assertEquals(1000,result.getMemDisco());
        assertEquals(16, result.getMemRam());
        assertEquals("Intel I7 Test", result.getMicroprocesador());
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/listar", Laptop[].class);
        System.out.println("Cantidad de Laptops cargadas: " + response.getBody().length);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/listar/99999", Laptop.class);
        System.out.println("Id: " + response.getBody().getIdLaptop() + "\n" +
                           "Marca: " + response.getBody().getMarca() + "\n" +
                           "Modelo: " + response.getBody().getModelo() + "\n" +
                           "Memoria de Disco: " + response.getBody().getMemDisco() + " GB \n" +
                           "Memoria RAM: " + response.getBody().getMemRam() + " GB \n" );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void update() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        //Previamente deberiamos ingresar un registro con ese id para actualizarlo
        //Actualizamos el registro insertado
        String jsonAct = """
                        {
                            "marca": "TestActualizado",
                            "modelo": "TestActualizado",
                            "memDisco": 2,
                            "memRam": 2,
                            "microprocesador": "TestActualizado", 
                            "idLaptop": 999999
                        }
                    """;
        HttpEntity<String> requestAct = new HttpEntity<>(jsonAct, header);
        ResponseEntity<Laptop> responseAct = testRestTemplate.exchange("/api/actualizar", HttpMethod.PUT, requestAct, Laptop.class);

        Laptop resultAct = responseAct.getBody();
        System.out.println(resultAct.getMarca());
        assertEquals(999999, resultAct.getIdLaptop());
        assertEquals("TestActualizado", resultAct.getMarca());
        assertEquals("TestActualizado", resultAct.getModelo());
        assertEquals(2,resultAct.getMemDisco());
        assertEquals(2, resultAct.getMemRam());
        assertEquals("TestActualizado", resultAct.getMicroprocesador());
    }

    @Test
    void delete() {
        //Con esto indicamos que se va a enviar datos en formato JSON
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                    {
                        "idLaptop": 999999
                    }
                    """;
        //Creamos la request, similar a lo que hacemos desdes Postman
        HttpEntity<String> request = new HttpEntity<>(json, header);
        ResponseEntity response = testRestTemplate.exchange("/api/eliminar/999999", HttpMethod.DELETE, request, Laptop.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void saveLaptops() {
        //Con esto indicamos que se va a enviar datos en formato JSON
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = """
                    [
                        {
                            "marca": "Test1",
                            "modelo": "Test1",
                            "memDisco": 1,
                            "memRam": 1,
                            "microprocesador": "Test1"
                        },
                        {
                            "marca": "Test2",
                            "modelo": "Test2",
                            "memDisco": 2,
                            "memRam": 2,
                            "microprocesador": "Test2"
                        }
                    ]
                    """;
        //Creamos la request, similar a lo que hacemos desdes Postman
        HttpEntity<String> request = new HttpEntity<>(json, header);
        System.out.println(request);
        ResponseEntity<Laptop[]> response = testRestTemplate.exchange("/api/guardarLaptops", HttpMethod.POST, request, Laptop[].class);

        Laptop[] result = response.getBody();
        assertEquals("Test1", result[0].getMarca());
        assertEquals("Test1", result[0].getModelo());
        assertEquals(1,result[0].getMemDisco());
        assertEquals(1, result[0].getMemRam());
        assertEquals("Test1", result[0].getMicroprocesador());

        assertEquals("Test2", result[1].getMarca());
        assertEquals("Test2", result[1].getModelo());
        assertEquals(2,result[1].getMemDisco());
        assertEquals(2, result[1].getMemRam());
        assertEquals("Test2", result[1].getMicroprocesador());
    }
}