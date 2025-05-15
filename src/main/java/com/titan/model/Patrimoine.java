package com.titan.model;

import java.time.LocalDate;
import java.util.Set;

public record Patrimoine(Personne possesseur, LocalDate date, Double valeur, Set<Possession> possessions) {

    public Double projectionFuture (LocalDate dateFuture){
        return possessions.stream().map(possession -> possession.projectionFuture(dateFuture).getValeur().getMontant()).reduce(Double::sum).get();
    }
}
