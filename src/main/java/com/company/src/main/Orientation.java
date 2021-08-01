package com.company.src.main;

public enum Orientation {
  NORD("N") ,
  OUEST("O"),
  SUD("S"),
  EST("E");

  private String abreviation;

  private Orientation(String abreviation){
    this.abreviation = abreviation;
  }

  public String getAbreviation(){
    return this.abreviation;
  }
}
