package main;

import java.util.List;

public class GerenciadorEventos {
	
	private List<Evento> eventos;

	public GerenciadorEventos() {
	    eventos = ArquivoUtil.carregar();
	    if (eventos == null) {
	        eventos = new java.util.ArrayList<>();
	    }
	    
	    }

	public void adicionarEvento(Evento e) {
		if (e != null) {
		    eventos.add(e);
		    ArquivoUtil.salvar(eventos);
		}
    }

    public void listarOrdenado() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
            return;
        }

        eventos.sort(java.util.Comparator.comparing(Evento::getHorario));

        for (int i = 0; i < eventos.size(); i++) {
            System.out.println(i + " - " + eventos.get(i));
        }
    }

    public Evento getEvento(int indice) {
        if (indice >= 0 && indice < eventos.size()) {
            return eventos.get(indice);
        }
        throw new IllegalArgumentException("Índice inválido");
    }

    public void verificarEventos() {
        java.time.LocalDateTime agora = java.time.LocalDateTime.now();

        for (Evento e : eventos) {
            if (e.getHorario().isBefore(agora)) {
                System.out.println("Já ocorreu: " + e);
            } else if (e.getHorario().isEqual(agora)) {
                System.out.println("Acontecendo agora: " + e);
            } else {
                System.out.println("Em Breve: " + e);
            }
        }
    }
    public void participar(Evento evento, String usuario) {

    	if(evento.isEventoJaPassou()) {
            System.out.println("Não é possível participar de um evento já encerrado.");
            return;
        }

        System.out.println(usuario + " participou do evento.");
    }
}