package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    	System.out.println("Rodando!");
    	Scanner sc = new Scanner(System.in);
    	GerenciadorEventos ger = new GerenciadorEventos();

    	Usuario usuario = null;
	
	int opcao;
	do {

	    System.out.println("\n=== MENU ===");
	    System.out.println("1 - Cadastrar usuário");
	    System.out.println("2 - Cadastrar evento");
	    System.out.println("3 - Listar eventos");
	    System.out.println("4 - Participar de evento");
	    System.out.println("5 - Ver minhas participações");
	    System.out.println("6 - Cancelar participação");
	    System.out.println("7 - Verificar eventos");
	    System.out.println("0 - Sair");
	    System.out.print("Escolha: ");

	    opcao = sc.nextInt();
	    sc.nextLine();

	    switch (opcao) {
	    case 1:
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Cidade: ");
            String cidade = sc.nextLine();

            usuario = new Usuario(nome, email, cidade);

            System.out.println("Usuário cadastrado com sucesso!");
            break;
	    
	    case 2:
	    	System.out.print("Nome do evento: ");
	        String nomeEvento = sc.nextLine().trim();

	    	System.out.print("Endereço: ");
	    	String endereco = sc.nextLine().trim();

	    	System.out.println("Categoria:");
	    	System.out.println("1 - Festa");
	    	System.out.println("2 - Show");
	    	System.out.println("3 - Esportivo");
	    	System.out.println("4 - Tecnologia");
	    	System.out.println("5 - Outros");

	    	System.out.print("Escolha a categoria: ");
	    	int cat = sc.nextInt();
	    	sc.nextLine();

	    	String categoria;

	    	switch (cat) {
	    	    case 1:
	    	        categoria = "Festa";
	    	        break;
	    	    case 2:
	    	        categoria = "Show";
	    	        break;
	    	    case 3:
	    	        categoria = "Esportivo";
	    	        break;
	    	    case 4:
	    	        categoria = "Tecnologia";
	    	        break;
	    	    default:
	    	        categoria = "Outros";
	    	}

	    	System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
	    	String data = sc.nextLine().trim();

	    	java.time.format.DateTimeFormatter formatter =
	    	    java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	    	java.time.LocalDateTime dataHora =
	    	    java.time.LocalDateTime.parse(data, formatter);

	    	System.out.print("Descrição: ");
	    	String descricao = sc.nextLine().trim();
	    	
	    	

	    	Evento e = new Evento(
	    	    nomeEvento,
	    	    endereco,
	    	    categoria,
	    	    java.time.LocalDateTime.parse(data, formatter),
	    	    descricao
	    	);

	    	ger.adicionarEvento(e);
	    	System.out.println("Evento cadastrado!");
	        break;

	    case 3:
	        ger.listarOrdenado();
	        break;

	    case 4:
	        if (usuario == null) {
	            System.out.println("Cadastre um usuário antes de participar de eventos.");
	            break;
	        }

	        ger.listarOrdenado();

	        System.out.print("Digite o índice do evento: ");
	        int indice = sc.nextInt();
	        sc.nextLine();

	        Evento escolhido = ger.getEvento(indice);

	        if (escolhido != null) {
	            usuario.participarEvento(escolhido);
	        } else {
	            System.out.println("Evento inválido.");
	        }

	        break;

	    case 5:
	        if (usuario == null) {
	            System.out.println("Cadastre um usuário primeiro.");
	            break;
	        }

	        usuario.listarParticipacoes();
	        break;
	        
	        
	    case 6:
	        if (usuario == null) {
	            System.out.println("Cadastre um usuário primeiro.");
	            break;
	        }

	        usuario.listarParticipacoes();

	        System.out.print("Digite o índice do evento para cancelar: ");
	        int i = sc.nextInt();
	        sc.nextLine();

	        Evento eventoCancelar = usuario.getEventoParticipando(i);

	        if (eventoCancelar != null) {
	            usuario.cancelarParticipacao(eventoCancelar);
	        } else {
	            System.out.println("Evento inválido.");
	        }

	        break;
	        
	    case 7:
	        ger.verificarEventos();
	        break;
	        
	        
	    case 0:
	        System.out.println("Saindo...");
	        break;

	    default:
	        System.out.println("Opção inválida.");
	}
	    
	    
	    
	    
	} while (opcao != 0);
	sc.close();
}
}