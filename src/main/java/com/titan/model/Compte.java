package com.titan.model;

import static com.titan.model.Argent.ariary;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public final class Compte extends Possession {
  private final Set<TrainDeVie> trainDeVies;
  private final LocalDate dateDeCreation;

  public Compte(String nom, Argent valeur, LocalDate aDateDe, LocalDate dateDeCreation) {
    super(nom, valeur, aDateDe);
    this.dateDeCreation = dateDeCreation;
    this.trainDeVies = new HashSet<>();
  }

  public void financer(TrainDeVie trainDeVie) {
    trainDeVies.add(trainDeVie);
  }

  @Override
  public Compte projectionFuture(LocalDate dateFuture) {
    if (dateFuture.isBefore(this.getADateDe())) {
      return new Compte(nom, ariary(0d), dateFuture, dateDeCreation);
    }

    Argent sommeTotaleTrainDeVie =
        new HashSet<>(trainDeVies).stream()
            .map(trainDeVie -> trainDeVie.projectionFuture(dateFuture).getValeur())
            .reduce(Argent::additionner)
            .orElse(ariary(0d));

    return new Compte(nom, valeur.soustraire(sommeTotaleTrainDeVie), dateFuture, dateDeCreation);
  }
}
