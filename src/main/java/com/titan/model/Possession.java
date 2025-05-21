package com.titan.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public abstract sealed class Possession permits Compte, Materiel, TrainDeVie {
    protected final String nom;
    protected final Argent valeur;
    protected final LocalDate aDateDe;

    public abstract Possession projectionFuture (LocalDate dateFuture);
    public Argent valeurFuture (LocalDate dateFuture, Devise devise){
        return projectionFuture(dateFuture).getValeur().convertir(devise);
    }
}
