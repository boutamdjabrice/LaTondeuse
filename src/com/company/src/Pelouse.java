package com.company.src;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pelouse {

  int cordX;
  int cordY;

  public Pelouse(int cordX, int cordY){
    this.cordX = cordX;
    this.cordY = cordY;
  }
}
