package com.titan.model;

import java.time.LocalDate;

public final class TrainDeVie extends Possession {
    public TrainDeVie(String nom, Argent valeur, LocalDate aDateDe) {
        super(nom, valeur, aDateDe);
    }

    @Override
  public Possession projectionFuture(LocalDate dateFuture) {
    if (dateFuture.isBefore(this.getADateDe())) {
      Argent argent = new Argent(0d, this.getValeur().getDevise());
      return new Compte(this.getNom(), argent, this.getADateDe());
    }
    return this;
  }
}
