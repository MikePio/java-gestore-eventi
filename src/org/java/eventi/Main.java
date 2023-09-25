package org.java.eventi;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {

		try {
			LocalDate dataEvento = LocalDate.parse("2033-09-25");
			// test errore
			// LocalDate dataEvento = LocalDate.parse("2022-09-25");
			
			Evento evento1 = new Evento("Marrageddon", dataEvento, 100);

			// incrementa di 1 posti prenotati oppure stampa l'errore con Exception per il metodo prenota
			evento1.prenota();
			evento1.prenota();
			// decrementa di 1 posti prenotati oppure stampa l'errore con Exception per il metodo disdici
			evento1.disdici();


			System.out.println(evento1);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
