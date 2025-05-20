package com.titan.model;

import static com.titan.model.Argent.ariary;
import static java.time.temporal.ChronoUnit.MONTHS;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public final class TrainDeVie extends Possession {
  private final Compte financeur;
  private final int jourDePonction;
  private final LocalDate debutDePonction;

  public TrainDeVie(
      String nom,
      Argent valeur,
      LocalDate aDateDe,
      Compte financeur,
      int jourDePonction,
      LocalDate debutDePonction) {
    super(nom, valeur, aDateDe);
    this.financeur = financeur;
    this.jourDePonction = jourDePonction;
    this.debutDePonction = debutDePonction;
  }

  @Override
  public TrainDeVie projectionFuture(LocalDate dateFuture) {
    if (dateFuture.isBefore(this.getADateDe())) {
      return new TrainDeVie(nom, ariary(0d), aDateDe, financeur, jourDePonction, debutDePonction);
    }

    int moisEcoulee = (int) MONTHS.between(debutDePonction, dateFuture);

    if (dateFuture.getDayOfMonth() >= jourDePonction) {
      moisEcoulee -= 1;
    }
    Argent valeurRestante =
        financeur.getValeur().soustraire(ariary(valeur.getMontant() * moisEcoulee));
    Compte financeurFutur = new Compte(financeur.getNom(), valeurRestante, dateFuture);
    return new TrainDeVie(nom, valeur, dateFuture, financeurFutur, jourDePonction, debutDePonction);
  }
}
