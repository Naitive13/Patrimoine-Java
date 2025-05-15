package com.titan.model;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public final class Materiel extends Possession {
    private final LocalDate dateAcquisition;
    private final Double tauxAmortissement;

    public Materiel(String nom, Argent valeur, LocalDate aDateDe, LocalDate dateAcquisition, Double tauxAmortissement) {
        super(nom, valeur, aDateDe);
        this.dateAcquisition = dateAcquisition;
        this.tauxAmortissement = tauxAmortissement;
    }

    @Override
    public Possession projectionFuture (LocalDate dateFuture){
        if (dateFuture.isBefore(this.getDateAcquisition())) {
            Argent argent = new Argent(0d, this.getValeur().getDevise());
            return new Compte(this.getNom(), argent, this.getADateDe());
        }

        int differenceAnnee = dateFuture.getYear()-this.dateAcquisition.getYear();
        Double nouveauMontant = this.getValeur().getMontant() * Math.pow(1 - (this.getTauxAmortissement() / 100), differenceAnnee);
        Argent argent = new Argent(nouveauMontant,this.getValeur().getDevise());

        return new Materiel(this.getNom(),argent,dateFuture,this.getDateAcquisition(),this.getTauxAmortissement());
    }
}
