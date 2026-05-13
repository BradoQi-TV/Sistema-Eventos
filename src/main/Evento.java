package main;

import java.time.format.DateTimeFormatter;

public class Evento {
	
private String nome;
private String endereco;
private String categoria;
private String descricao;
private java.time.LocalDateTime horario;

// construtor (nao esquecer)
public Evento(String nome, String endereco, String categoria,
        java.time.LocalDateTime horario, String descricao) {
this.nome = nome;
this.endereco = endereco;
this.categoria = categoria;
this.horario = horario;
this.descricao = descricao;
}

public String getNome() { return nome; }
public String getEndereco() { return endereco; }
public String getCategoria() { return categoria; }
public String getDescricao() { return descricao; }
public java.time.LocalDateTime getHorario() { return horario; }


@Override
public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    return nome + " | " + categoria + " | " + horario.format(formatter);
}
public boolean isEventoJaPassou() {
    return horario.isBefore(java.time.LocalDateTime.now());
}
}