package org.java.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class Concerto extends Evento {

  private LocalTime ora;
  private BigDecimal prezzo;

  public Concerto(String titolo, LocalDate data, int numeroPostiTotali, LocalTime ora, BigDecimal prezzo) throws Exception {
    super(titolo, data, numeroPostiTotali);
    setOra(ora);
    setPrezzo(prezzo);
  }

  public LocalTime getOra() {
    return ora;
  }

  public void setOra(LocalTime ora) {
    this.ora = ora;
  }

  public BigDecimal getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(BigDecimal prezzo) {
    this.prezzo = prezzo;
  }
  
  // metodo per formattare il prezzo come "##,##€"
  private String formatPrice(BigDecimal price) {
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ITALY);
    symbols.setDecimalSeparator(',');
    symbols.setCurrencySymbol("€");

    DecimalFormat decimalFormat = new DecimalFormat("0.00€", symbols);
    return decimalFormat.format(price);
  }

  @Override
  public String toString() {
    return "\nData e ora: " + getData() + " " + ora + " " + "\nTitolo: " + getTitolo() + "\nPrezzo: " + formatPrice(prezzo) + "\n" ;
  }

}
