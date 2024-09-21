package SlaughterHouse;

import Entities.AnimalType;

import java.util.Random;
import Entities.Animals;
import Utils.Log;


public class Station1 implements Runnable
{
  private int idCount;
  private final ProductionLine productionLine;
  public Station1(ProductionLine productionLine)
  {
    this.productionLine = productionLine;
    idCount = 0;
  }
  public void generateRegisterNumber(){
    idCount++;
  }
  public int generateWeight(AnimalType AnimalType){
    Random randomNumbers = new Random();
    switch(AnimalType){
      case COW:
        return randomNumbers.nextInt(500, 1000);
      case PIG:
        return randomNumbers.nextInt(100, 200);
      case CHICKEN:
        return randomNumbers.nextInt(1, 5);
      case TURKEY:
        return randomNumbers.nextInt(10, 20);
      case DUCK:
        return randomNumbers.nextInt(5, 10);
    }
    return 0;
  }
  private synchronized void registration() throws InterruptedException
  {
    Random randomNumbers = new Random();
    int number = randomNumbers.nextInt(1, 5);
    switch(number){
      case 0:
        generateRegisterNumber();
        productionLine.put(Animals.getInstance(AnimalType.COW, idCount, generateWeight(AnimalType.COW)));
        Log.getInstance().logAction("Station 1 registered the Cow");
        break;
      case 1:
        generateRegisterNumber();
        productionLine.put(Animals.getInstance(AnimalType.PIG, idCount, generateWeight(AnimalType.PIG)));
        Log.getInstance().logAction("Station 1 registered the Pig");
        break;
      case 2:
        generateRegisterNumber();
        productionLine.put(Animals.getInstance(AnimalType.CHICKEN, idCount, generateWeight(AnimalType.CHICKEN)));
        Log.getInstance().logAction("Station 1 registered the Chicken");
        break;
      case 3:
        generateRegisterNumber();
        productionLine.put(Animals.getInstance(AnimalType.TURKEY, idCount, generateWeight(AnimalType.TURKEY)));
        Log.getInstance().logAction("Station 1 registered the Turkey");
        break;
      case 4:
        generateRegisterNumber();
        productionLine.put(Animals.getInstance(AnimalType.DUCK, idCount, generateWeight(AnimalType.DUCK)));
        Log.getInstance().logAction("Station 1 registered the Duck ");
        break;
    }
  }

  @Override public void run()
  {
    while(true){
      try{
        Log.getInstance().logAction("Station 1 is registering...");
        registration();
      } catch (InterruptedException e){
        throw new RuntimeException(e);
      }
      try{
        Log.getInstance().logAction("Station 1 is inactive...");
        Thread.sleep(20000);
      } catch (InterruptedException e){
        throw new RuntimeException(e);
      }
    }
  }
}
