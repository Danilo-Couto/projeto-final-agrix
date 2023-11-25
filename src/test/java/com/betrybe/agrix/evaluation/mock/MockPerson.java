package com.betrybe.agrix.evaluation.mock;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Mock person.
 */
public class MockPerson extends HashMap<String, Object> {

  /**
   * Instantiates a new Mock person.
   */
  public <K, V> MockPerson() {
    super();
  }

  /**
   * Instantiates a new Mock person.
   *
   * @param source the source
   */
  public <K, V> MockPerson(Map<K, V> source) {
    super((Map<String, Object>) source);
  }

  public MockPerson clone() {
    return new MockPerson(this);
  }
}
