package main;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    private static final String NOME_ARQUIVO = "events.data";
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Parte para salvar
    public static void salvar(List<Evento> eventos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {

            for (Evento e : eventos) {
                String linha = e.getNome() + ";" +
                               e.getEndereco() + ";" +
                               e.getCategoria() + ";" +
                               e.getHorario().format(formatter) + ";" +
                               e.getDescricao();

                writer.write(linha);
                writer.newLine();
            }

        } 
        
        catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
        
        
    }

    // Carregar os dados
    public static List<Evento> carregar() {
        List<Evento> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {

            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");

                LocalDateTime data =
                        LocalDateTime.parse(partes[3], formatter);

                Evento e = new Evento(
                        partes[0],
                        partes[1],
                        partes[2],
                        data,
                        partes[4]
                );

                lista.add(e);
            }

        } catch (IOException e) {
            // se não existir arquivo, ignora
        }

        return lista;
    }
}