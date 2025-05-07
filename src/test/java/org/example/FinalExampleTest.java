package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FinalExampleTest {

    String TEXTO_CERO_CARACTERES= "";
    String TEXTO_CON_SEPARACIONES = "texto1 texto2 texto3  texto12345678, texto5, texto6, texto7, texto8, texto9, texto10, texto11";
    String TEXTO_SIN_LETRAS = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
    String TEXTO_MAS_10_LONGITUD = "Texto para evaluar;";
    String TEXTO_CORTO = "UNO, dos";

    String NAME_USER = "Peter gg";
    String EMAIL_USER = "pg@email.com";
    String EMAIL_USER_INVALID = "pgemail.com";
    String PHONE_USER = "1234588";
    String ADDRESS_USER = "Xela z1";
    String CITY_USER = "Quetgo";
    String ZIP_USER = "0901";

    FinalExample finalExample;
    FinalExample.Order order;
    FinalExample.ReportGenerator generator;

    String NOMBRE_ITEM = "ITEM1";
    double TOTAL = 12.3;

    @BeforeEach
    void setUp() {
        finalExample = new FinalExample();
        order = new FinalExample.Order();
        generator = new FinalExample.ReportGenerator();
    }

    // METODO processData
    @Test
    void textoCeroCaracteres (){
        finalExample.processData(TEXTO_CERO_CARACTERES);
    }

    @Test
    void textoConMasDeCeroCaracteres (){
        finalExample.processData(TEXTO_CON_SEPARACIONES);
    }

    @Test
    void textoConMasDe10Longitud (){
        finalExample.processData(TEXTO_MAS_10_LONGITUD);
    }

    @Test
    void textoSolamenteLetras (){
        finalExample.processData(TEXTO_CON_SEPARACIONES);
    }

    @Test
    void textoSinLetras (){
        finalExample.processData(TEXTO_SIN_LETRAS);
    }

    @Test
    void textoMenosDe10Caracteres(){
        finalExample.processData(TEXTO_CORTO);
    }

    //METODO createUser
    @Test
    void crearUsuarioCorrectamente(){

        String user = finalExample.createUser(NAME_USER, EMAIL_USER, PHONE_USER, ADDRESS_USER, CITY_USER, ZIP_USER );

        assertEquals("User created: " + NAME_USER, user);

    }

    @Test
    void crearUsuarionNombreNull(){

        String user = finalExample.createUser(null, EMAIL_USER, PHONE_USER, ADDRESS_USER, CITY_USER, ZIP_USER );

        assertEquals("Name cannot be empty", user);

    }

    @Test
    void crearUsuarionNombreEmpty(){

        String result = finalExample.createUser("", EMAIL_USER, PHONE_USER, ADDRESS_USER, CITY_USER, ZIP_USER );

        assertEquals("Name cannot be empty", result);

    }

    @Test
    void crearUsuarionEmailNull(){

        String result = finalExample.createUser(NAME_USER, null, PHONE_USER, ADDRESS_USER, CITY_USER, ZIP_USER );

        assertEquals("Invalid email", result);

    }

    @Test
    void crearUsuarionEmailInvalido(){

        String result = finalExample.createUser(NAME_USER, EMAIL_USER_INVALID, PHONE_USER, ADDRESS_USER, CITY_USER, ZIP_USER );

        assertEquals("Invalid email", result);
    }


    //reporte generados
    @Test
    void generarReporteCorrectamenteImprimirNombre(){
        String nombre = generator.printHeader(NAME_USER);
        assertEquals(NAME_USER, nombre);
    }

    @Test
    void generarReporteCorrectamenteImprimirItem(){
        String nombre = generator.printLineItem(NOMBRE_ITEM);
        assertEquals(NOMBRE_ITEM, nombre);
    }

    @Test
    void generarReporteCorrectamenteImprimirTotal(){
        double nombre = generator.printTotal(TOTAL);
        assertEquals(TOTAL, nombre);
    }


    //Area
    @Test
    void CalcularAreaCirculoCorrectamente(){
       double resultado =  finalExample.calculateArea("circle", 1);
       assertEquals(3.141592653589793, resultado);
    }

    @Test
    void CalcularAreaRectanguloCorrectamente(){
        double resultado =  finalExample.calculateArea("rectangle", 1,2);
        assertEquals(2, resultado);
    }

    @Test
    void CalcularAreaTrianguloCorrectamente(){
        double resultado =  finalExample.calculateArea("triangle", 1,2);
        assertEquals(1.0, resultado);
    }

}
