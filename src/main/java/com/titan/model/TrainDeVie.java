package com.titan.model;

import static com.titan.model.Argent.ariary;

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

    long nombreTransaction =
        debutDePonction
            .datesUntil(dateFuture.plusDays(1))
            .filter(localDate -> localDate.getDayOfMonth() == jourDePonction)
            .count();
    Argent argentFuture = valeur.multiplier(nombreTransaction);

    return new TrainDeVie(
        nom, argentFuture, dateFuture, financeur, jourDePonction, debutDePonction);
  }
}
