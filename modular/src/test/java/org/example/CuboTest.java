package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CuboTest {

    @Test
    void cubo() {

//        assertAll(
//                () -> assertEquals(2,Cubo.cubo(2)),
//                () -> assertEquals(30,Cubo.cubo(3))
//        );

        String entradaSimulada = "2";
        System.setIn(new ByteArrayInputStream(entradaSimulada.getBytes()));

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        assertEquals(8,Cubo.cubo());

        String salidaEsperada = "Introduce un número...";
        assertTrue(salida.toString().contains(salidaEsperada));

//        assertEquals(30,Cubo.cubo());

    }

    @Test
    void par() {
        assertFalse(Cubo.par(3));
        assertTrue(Cubo.par(10));
    }

}