package com.titan.model;

import lombok.Getter;

@Getter
public enum Devise {
  ARIARY(1d),
  USD(4200d),
  EURO(4000d);

  private final double valeurEnAriary;

  Devise(double tauxDeChangeVersAriary) {
    this.valeurEnAriary = tauxDeChangeVersAriary;
  }
}
