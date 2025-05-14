package com.titan.model;

import java.time.LocalDate;
import java.util.Set;

public record Patrimoine(LocalDate date, Double valeur, Set<Possession> possessions) {
}
