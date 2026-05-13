package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    	System.out.println("Rodando!");
	Scanner sc = new Scanner(System.in);
	GerenciadorEventos ger = new GerenciadorEventos();

	Usuario usuario = new Usuario(
	    "Andre",
	    "andre@email.com",
	    "Jacarei"
	);
	
	
	int opcao;
	do {

	    System.out.println("\n=== MENU ===");
	    System.out.println("1 - Cadastrar evento");
	    System.out.println("2 - Listar eventos");
	    System.out.println("3 - Participar de evento");
	    System.out.println("4 - Ver minhas participações");
	    System.out.println("5 - Cancelar participação");
	    System.out.println("6 - Verificar eventos");
	    System.out.println("0 - Sair");
	    System.out.print("Escolha: ");

	    opcao = sc.nextInt();
	    sc.nextLine();

	    switch (opcao) {
	    case 1:
	    	System.out.print("Nome: ");
	    	String nome = sc.nextLine().trim();

	    	System.out.print("Endereço: ");
	    	String endereco = sc.nextLine().trim();

	    	System.out.print("Categoria: ");
	    	String categoria = sc.nextLine().trim();

	    	System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
	    	String data = sc.nextLine().trim();

	    	java.time.format.DateTimeFormatter formatter =
	    	    java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	    	java.time.LocalDateTime dataHora =
	    	    java.time.LocalDateTime.parse(data, formatter);

	    	System.out.print("Descrição: ");
	    	String descricao = sc.nextLine().trim();
	    	
	    	

	    	Evento e = new Evento(
	    	    nome,
	    	    endereco,
	    	    categoria,
	    	    java.time.LocalDateTime.parse(data, formatter),
	    	    descricao
	    	);

	    	ger.adicionarEvento(e);
	    	System.out.println("Evento cadastrado!");
	        break;

	    case 2:
	        ger.listarOrdenado();
	        break;

	    case 3:
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

	    case 4:
	        usuario.listarParticipacoes();
	        break;
	        
	        
	    case 5:
	        usuario.listarParticipacoes();

	        System.out.print("Digite o índice do evento para cancelar: ");
	        int i = sc.nextInt();
	        sc.nextLine();
	      //teste de funcionamento da lista de evento usuario
	        Evento eventoCancelar = usuario.getEventoParticipando(i);

	        if (eventoCancelar != null) {
	            usuario.cancelarParticipacao(eventoCancelar);
	        } else {
	            System.out.println("Evento inválido.");
	        }
	        break;
	        
	    case 6:
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