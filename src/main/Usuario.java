package main;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nome;
	private String email;
	private String cidade;
	
	private List<Evento> eventosParticipando = new ArrayList<>();
	
	public Usuario(String nome, String email, String cidade) {
		this.nome = nome;
		this.email = email;
		this.cidade = cidade;
		
	}
	
	public void participarEvento(Evento e) {
		
		if (e.isEventoJaPassou()) {
		    System.out.println("Não é possível participar de um evento já encerrado.");
		    return;
	    }
		 if (eventosParticipando.contains(e)) {
		        System.out.println("Você já está participando deste evento.");
		        return;
		    }
	    eventosParticipando.add(e);
	    System.out.println("Participação confirmada!");
	}
	
	public void cancelarParticipacao(Evento e) {
	    if (eventosParticipando.remove(e)) {
	        System.out.println("Participação cancelada!");
	    } else {
	        System.out.println("Você não está nesse evento.");
	    }
	}
	
	public void listarParticipacoes() {
	    if (eventosParticipando.isEmpty()) {
	        System.out.println("Nenhum evento confirmado.");
	        return;
	    }

	    for (int i = 0; i < eventosParticipando.size(); i++) {
	        System.out.println(i + " - " + eventosParticipando.get(i));
	    }
	}
	
	//teste de funcionamento da lista de evento usuario
	public Evento getEventoParticipando(int indice) {
	    if (indice >= 0 && indice < eventosParticipando.size()) {
	        return eventosParticipando.get(indice);
	    }
	    return null;
	}
	
	public String getNome() {
		return nome;
	}
}

	