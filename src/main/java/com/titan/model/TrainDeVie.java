package com.titan.model;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;

import static com.titan.model.Argent.ariary;
import static java.time.temporal.ChronoUnit.MONTHS;

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

    int moisEcoulee = (int) MONTHS.between(dateFuture,debutDePonction);

    if(dateFuture.getDayOfMonth() >= jourDePonction){
      Argent valeurFuture = financeur.getValeur().soustraire(ariary(valeur.getMontant()*moisEcoulee));
    }
  }
}
