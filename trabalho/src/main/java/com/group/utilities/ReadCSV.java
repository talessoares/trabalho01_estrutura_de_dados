package com.group.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {

    private String filePath;
    private String content;

    public ReadCSV(String filePath) {
        this.filePath = filePath;
        this.content = "";
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        if(filePath == null || filePath.trim().isEmpty()) {
            throw new NullPointerException("Caminho do arquivo não pode ser nulo!");
        }

        this.filePath = filePath;
    }

    public void read() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(this.filePath));

            String line = null;
            this.content = "";

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                for (String value : values) {
                    this.content += value + ";";
                }
                this.content += "\n";
            }

        } catch (IOException e) {
            throw new NullPointerException("Arquivo não encontrado!");
        } catch(Exception e) {
            throw new NullPointerException("Erro inesperado ao ler o arquivo!");
        } finally {
            // CASO O ARQUIVO NÃO SEJA ENCONTRADO
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new NullPointerException("Erro ao fechar o arquivo!");
                } catch(Exception e) {
                    throw new NullPointerException("Erro inesperado ao fechar o arquivo!");
                }
            }
        }
    }

    public String getContent() {
        if(this.content == null || this.content.trim().isEmpty()) {
            throw new NullPointerException("Arquivo não lido anteriormente!");
        }

        return this.content;
    }

}
