package com.titan.model;

import java.time.LocalDate;
import java.util.Set;

public class Patrimoine {
    private final LocalDate date;
    private final Double valeur;
    private final Set<Possession> possessions;

    public Patrimoine(LocalDate date, Double valeur, Set<Possession> possessions) {
        this.date = date;
        this.valeur = valeur;
        this.possessions = possessions;
    }
}
