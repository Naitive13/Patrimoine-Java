package com.titan.model;

import java.time.LocalDate;
import lombok.Getter;

import static com.titan.model.Argent.ariary;

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
  public Materiel projectionFuture(LocalDate dateFuture) {
    if (dateFuture.isBefore(dateAcquisition)) {
      return new Materiel(nom, ariary(0d), dateFuture, dateAcquisition, tauxAmortissement);
    }

    int differenceAnnee = dateFuture.getYear() - dateAcquisition.getYear();
    Argent valeurAmoritssement = valeur.multiplier(tauxAmortissement);
    Argent valeurFuture = valeur.soustraire(valeurAmoritssement.multiplier(differenceAnnee));


    return new Materiel(nom, valeurFuture, dateFuture, dateAcquisition, tauxAmortissement);
  }
}
