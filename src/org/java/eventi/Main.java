package org.java.eventi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		LocalTime ora = null;
		// BigDecimal prezzo = null;

		try {
			System.out.println("\nCrea un nuovo evento: ");
			System.out.print("Inserisci il titolo dell'evento: ");
			String titolo = sc.nextLine();

			System.out.print("Inserisci la data dell'evento(es: 2033-09-05): ");
			String dataEvento = sc.nextLine();
			// dataEvento convertita da stringa a LocalDate
			LocalDate data = LocalDate.parse(dataEvento);

			System.out.print("Inserisci i posti totali disponibili dell'evento: ");
			int numeroPostiTotali = Integer.valueOf(sc.nextLine());
			
			Evento evento = new Evento(titolo, data, numeroPostiTotali);

			// incrementa di 1 posti prenotati oppure stampa l'errore con Exception per il metodo prenota
			// evento.prenota();
			// evento.prenota();
			// decrementa di 1 posti prenotati oppure stampa l'errore con Exception per il metodo disdici
			// evento.disdici();

			System.out.println(evento);
			
			System.out.print("\nQuanti posti vuoi prenotare? ");
			int postiDaPrenotare = Integer.valueOf(sc.nextLine());
			for(int i = 0; i<postiDaPrenotare; i++){
				evento.prenota();
			} 
			
			System.out.println(evento);

			System.out.print("\nQuanti posti vuoi disdire? ");
			int postiDaDisdire = Integer.valueOf(sc.nextLine());
			for(int i = 0; i<postiDaDisdire; i++){
				evento.disdici();
			} 
			
			System.out.println(evento + "\nPosti disdetti: " + postiDaDisdire + "\n" );
			
			System.out.print("\nInserisci l'ora dell'evento(es: 17:01): ");
			String oraString = sc.nextLine();
			ora = LocalTime.parse(oraString);

			System.out.print("\nInserisci il prezzo del biglietto dell'evento(es: 10.09): ");
			String prezzoStr = sc.next();
			BigDecimal prezzo = new BigDecimal(prezzoStr);

			Concerto concerto = new Concerto(titolo, data, numeroPostiTotali, ora, prezzo);
			
			System.out.println(evento + " " + concerto);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}
}
