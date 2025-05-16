package com.titan.model;

import lombok.Data;

@Data
public class Argent {
  private final Double montant;
  private final Devise devise;

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
