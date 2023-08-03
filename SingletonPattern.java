package design.pattern;

import java.io.Serializable;

/**
 *
 * Singleton can be broken by using the following techniques
 * 1 - Serialization
 * 2-  Reflection
 * 3-  clone
 * 4-  Multithreading
 *
 */
public class SingletonPattern implements Serializable, Cloneable {

  private static volatile SingletonPattern singletonPattern;

  private SingletonPattern() {
    if (singletonPattern != null) {
      throw new IllegalStateException("Use getInstance() method to get the single instance.");
    }
  }

  public static SingletonPattern getInstance() {
    if (singletonPattern == null) {
      synchronized (SingletonPattern.class) {
        if (singletonPattern == null) {
          return new SingletonPattern();
        }
      }
    }
    return singletonPattern;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new CloneNotSupportedException("Clone is not supported");
  }

  protected Object readResolver() {
    return getInstance();
  }

}
