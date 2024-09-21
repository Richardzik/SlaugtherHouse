package Entities;

import java.util.HashMap;

public class Animals
{
  private AnimalType key;
  private int registerNumber;
  private int weight;
  private static HashMap<AnimalType, Animals> instances = new HashMap<>();

  public Animals(AnimalType key, int registerNumber, int weight)
  {
    this.registerNumber = registerNumber;
    this.key = key;
    this.weight = weight;
  }
  private static Animals createInstance(AnimalType key, int registerNumber, int weight)
  {
    return new Animals(key, registerNumber, weight);
  }
  public static synchronized Animals getInstance(AnimalType key, int registerNumber, int weight)
  {
    if (!instances.containsKey(key))
    {
      instances.put(key, createInstance(key, registerNumber, weight));
    }
    return instances.get(key);
  }
  public int getRegisterNumber()
  {
    return registerNumber;
  }
  public int getWeight()
  {
    return weight;
  }
}
