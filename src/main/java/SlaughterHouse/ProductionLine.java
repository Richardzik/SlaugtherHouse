package SlaughterHouse;

import Entities.Animals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProductionLine implements BlockingQueue<Animals>
{
  private final ArrayList<Animals> animalsList;
  private final int capacity;
  public ProductionLine(int capacity)
  {
    this.capacity = capacity;
    this.animalsList = new ArrayList<>();
  }
  @Override public boolean add(Animals animals)
  {
    return false;
  }

  @Override public boolean offer(Animals animals)
  {
    return false;
  }

  @Override public Animals remove()
  {
    return null;
  }

  @Override public Animals poll()
  {
    return null;
  }

  @Override public Animals element()
  {
    return null;
  }

  @Override public Animals peek()
  {
    return null;
  }

  @Override public void put(Animals animals) throws InterruptedException
  {
    while (size() >= capacity) {
      wait();
    }
    animalsList.add(animals);
    notifyAll();
  }

  @Override public boolean offer(Animals animals, long timeout, TimeUnit unit)
      throws InterruptedException
  {
    return false;
  }

  @Override public Animals take() throws InterruptedException
  {
    return null;
  }

  @Override public Animals poll(long timeout, TimeUnit unit)
      throws InterruptedException
  {
    return null;
  }

  @Override public int remainingCapacity()
  {
    return 0;
  }

  @Override public boolean remove(Object o)
  {
    return false;
  }

  @Override public boolean containsAll(Collection<?> c)
  {
    return false;
  }

  @Override public boolean addAll(Collection<? extends Animals> c)
  {
    return false;
  }

  @Override public boolean removeAll(Collection<?> c)
  {
    return false;
  }

  @Override public boolean retainAll(Collection<?> c)
  {
    return false;
  }

  @Override public void clear()
  {

  }

  @Override public int size()
  {
    return 0;
  }

  @Override public boolean isEmpty()
  {
    return false;
  }

  @Override public boolean contains(Object o)
  {
    return false;
  }

  @Override public Iterator<Animals> iterator()
  {
    return null;
  }

  @Override public Object[] toArray()
  {
    return new Object[0];
  }

  @Override public <T> T[] toArray(T[] a)
  {
    return null;
  }

  @Override public int drainTo(Collection<? super Animals> c)
  {
    return 0;
  }

  @Override public int drainTo(Collection<? super Animals> c, int maxElements)
  {
    return 0;
  }
}
