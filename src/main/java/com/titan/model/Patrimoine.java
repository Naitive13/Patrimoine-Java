package com.titan.model;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record Patrimoine(Personne possesseur, LocalDate date, Set<Possession> possessions) {

  public Patrimoine projectionFuture(LocalDate dateFuture) {
    Set<Possession> possessionsFutur =
        possessions.stream()
            .map(possession -> possession.projectionFuture(dateFuture))
            .collect(Collectors.toSet());

    return new Patrimoine(possesseur, dateFuture, possessionsFutur);
  }
}
