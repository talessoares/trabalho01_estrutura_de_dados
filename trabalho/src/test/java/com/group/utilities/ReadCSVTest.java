package com.group.utilities;


import org.junit.Test;
import static org.junit.Assert.*;


public class ReadCSVTest {

    @Test
    public void lerArquivoExistente() {
        ReadCSV readCSV = new ReadCSV("../trabalho/src/test/java/com/group/csv/Categorias.csv");
        String content = null;

        try {
            readCSV.read();
            content = readCSV.getContent();
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertNotNull(content);
    }

    @Test
    public void lerArquivoNaoExistente() {
        ReadCSV readCSV = new ReadCSV("trabalho/src/test/java/com/group/csv/Categorias0.csv");
        NullPointerException exception = new NullPointerException("Arquivo não encontrado!");

        String content = null;

        try {
            readCSV.read();
            content = readCSV.getContent();
        } catch (Exception e) {
            assertEquals(exception.getMessage(), e.getMessage());
        }

        assertNull(content);
    }

    @Test
    public void lerArquivoVazio() {
        ReadCSV readCSV = new ReadCSV("../trabalho/src/test/java/com/group/csv/Vazio.csv");
        NullPointerException exception = new NullPointerException("Arquivo vazio!");

        String content = null;

        try {
            readCSV.read();
            content = readCSV.getContent();
        } catch (Exception e) {
            assertEquals(exception.getMessage(), e.getMessage());
        }

        assertNull(content);
    }




    
}
