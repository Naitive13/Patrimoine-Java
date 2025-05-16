package com.titan.model;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public final class Materiel extends Possession {
  private final LocalDate dateAcquisition;
  private final Double tauxAmortissement;

  public Materiel(
      String nom,
      Argent valeur,
      LocalDate aDateDe,
      LocalDate dateAcquisition,
      Double tauxAmortissement) {
    super(nom, valeur, aDateDe);
    this.dateAcquisition = dateAcquisition;
    this.tauxAmortissement = tauxAmortissement;
  }

  @Override
  public Possession projectionFuture(LocalDate dateFuture) {
    if (dateFuture.isBefore(dateAcquisition)) {
      Argent argent = new Argent(0d, valeur.getDevise());
      return new Compte(nom, argent, aDateDe);
    }

    int differenceAnnee = dateFuture.getYear() - dateAcquisition.getYear();
    double facteurAmortissementAnnuel = Math.pow(1 - (tauxAmortissement), differenceAnnee);
    Argent valeurFuture = valeur.multiplier(facteurAmortissementAnnuel);

    return new Materiel(nom, valeurFuture, dateFuture, dateAcquisition, tauxAmortissement);
  }
}
