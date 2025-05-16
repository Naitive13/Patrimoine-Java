package com.titan.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public abstract sealed class Possession permits Compte, Materiel, TrainDeVie {
    private final String nom;
    private final Argent valeur;
    private final LocalDate aDateDe;

    public abstract Possession projectionFuture (LocalDate dateFuture);
}
