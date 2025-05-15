package com.titan.model;

import lombok.Data;

@Data
public class Argent {
    private final Double montant;
    private final Devise devise;
}
