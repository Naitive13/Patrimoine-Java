package com.titan.model;

import lombok.Data;

@Data
public class Argent {
  private final Double montant;
  private final Devise devise;

  public static Argent ariary(double montant){
    return new Argent(montant, Devise.ARIARY);
  }

  public static Argent euro(double montant){
    return new Argent(montant, Devise.EURO);
  }

  public static Argent usDollar(double montant){
    return new Argent(montant, Devise.USD);
  }

  public Argent additionner(Argent argent) {
    return new Argent(this.montant + argent.getMontant(), this.devise);
  }

  public Argent soustraire(Argent argent) {
    return new Argent(this.montant - argent.getMontant(), this.devise);
  }

  public Argent multiplier(double facteur) {
    return new Argent(this.montant * facteur, this.devise);
  }
}
