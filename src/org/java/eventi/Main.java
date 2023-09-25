package org.java.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Crea un nuovo evento: ");
			System.out.print("Inserisci il titolo dell'evento: ");
			String titolo = sc.nextLine();
			System.out.print("Inserisci la data dell'evento(es: 2033-09-05): ");
			String dataEvento = sc.nextLine();
			// dataEvento convertita da stringa a LocalDate
			LocalDate data = LocalDate.parse(dataEvento);
			System.out.print("Inserisci i posti totali disponibili dell'evento: ");
			int numeroPostiTotali = Integer.valueOf(sc.nextLine());
			
			Evento evento1 = new Evento(titolo, data, numeroPostiTotali);

			// incrementa di 1 posti prenotati oppure stampa l'errore con Exception per il metodo prenota
			// evento1.prenota();
			// evento1.prenota();
			// decrementa di 1 posti prenotati oppure stampa l'errore con Exception per il metodo disdici
			// evento1.disdici();

			System.out.println(evento1);
			
			System.out.print("Quanti posti vuoi prenotare? ");
			int postiDaPrenotare = Integer.valueOf(sc.nextLine());
			for(int i = 0; i<postiDaPrenotare; i++){
				evento1.prenota();
			} 
			
			System.out.println(evento1);

			System.out.print("Quanti posti vuoi disdire? ");
			int postiDaDisdire = Integer.valueOf(sc.nextLine());
			for(int i = 0; i<postiDaDisdire; i++){
				evento1.disdici();
			} 
			
			System.out.println(evento1 + "Posti disdetti: " + postiDaDisdire + "\n" );
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}
}
