package org.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

  private String titolo; // lettura e scrittura
  private LocalDate data; // lettura e scrittura
  private int numeroPostiTotali; // solo lettura
  private int numeroPostiPrenotati; // solo lettura

  public Evento(String titolo, LocalDate data, int numeroPostiTotali) throws Exception{

    setTitolo(titolo);
    setData(data);
    setNumeroPostiTotali(numeroPostiTotali); //! impostato come privato perché è solo lettura
    this.numeroPostiPrenotati = 0;
  }

  // getter and setter -------------------------------------------------------------------

  // get = lettura
  public String getTitolo() {
    return titolo;
  }

	// set = scrittura
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) throws Exception{
    // controllo per far sì che la data non sia già passata
    // isBefore confronta data(data inserita) con LocalDate.now()(la data di oggi)
    if (data.isBefore(LocalDate.now())) {
      throw new Exception("L'evento è già passato");
    }

    this.data = data;
  }

  public int getnumeroPostiTotali() {
    return numeroPostiTotali;
  }

  //! private set = lettura
  private void setNumeroPostiTotali(int numeroPostiTotali) throws Exception{

    // controllo per far sì che il numero di posti totali sia positivo
    if (numeroPostiTotali <= 0) {
      throw new Exception("Ci deve essere almeno un posto totale");
    }
  }

  public int getNumeroPostiPrenotati() {
    return numeroPostiPrenotati;
  }

  // metodi-------------------------------------------------------------------

  public void prenota() throws Exception{

    // controllo per far sì che la data non sia già passata
    // isBefore confronta data(data inserita) con LocalDate.now()(la data di oggi)
    if(data.isBefore(LocalDate.now())){
      throw new Exception("Non puoi prenotare, l’evento è già passato");
    }else if(numeroPostiPrenotati < numeroPostiTotali){
      throw new Exception("Non puoi prenotare, non ci sono posti disponibili");
    }else{
      numeroPostiPrenotati++;
      System.out.println(numeroPostiPrenotati + "Posti Prenotati");
      System.out.println(numeroPostiTotali + "Posti Totali");
    }
  }

  public void disdici() throws Exception{

    // controllo per far sì che la data non sia già passata
    // isBefore confronta data(data inserita) con LocalDate.now()(la data di oggi)
    if(data.isBefore(LocalDate.now())){
      throw new Exception("Non puoi disdire, l’evento è già passato");
    }else if(numeroPostiPrenotati == 0){
      throw new Exception("Non puoi disdire, non ci sono prenotazioni disponibili");
    }else{
      numeroPostiPrenotati--;
    }
  }

  @Override
  public String toString() {
    DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return "Titolo evento: " + titolo 
    + "\ndata: " + data.format(dataFormattata) 
    + "\nPosti totali: " + numeroPostiTotali
    + "\nPosti prenotati: " + numeroPostiPrenotati +"\n";
  }

  public void setNumeroPostiPrenotati(int numeroPostiPrenotati) {
    this.numeroPostiPrenotati = numeroPostiPrenotati;
  }
}