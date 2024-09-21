package SlaughterHouse;

import Entities.Animals;

import java.util.ArrayList;

public class Station2 implements Runnable
{
  private final ProductionLine productionLine; // Line from 1 -> 2
  private final ProductionLine productionLine2; // Line from 2 -> 3
  private ArrayList<Animals> animalsToBeSlaughtered;
  public Station2(ProductionLine productionLine, ProductionLine productionLine2)
  {
    this.productionLine = productionLine;
    this.productionLine2 = productionLine2;
  }
  private synchronized void slaughter() throws InterruptedException
  {
    Animals animals = productionLine.take();
    animalsToBeSlaughtered.add(animals);

  }
}
