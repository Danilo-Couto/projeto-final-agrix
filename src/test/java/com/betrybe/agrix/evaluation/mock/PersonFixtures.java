package com.betrybe.agrix.evaluation.mock;

import java.util.Map;

/**
 * The type Person fixtures.
 */
public class PersonFixtures {

  /**
   * The constant person_user.
   */
  public final static MockPerson person_user = new MockPerson(Map.of(
      "username", "maria",
      "password", "senhasecreta",
      "role", "USER"
  ));

  /**
   * The constant person_manager.
   */
  public final static MockPerson person_manager = new MockPerson(Map.of(
      "username", "joao",
      "password", "meuaniversario",
      "role", "MANAGER"
  ));

  /**
   * The constant person_admin.
   */
  public final static MockPerson person_admin = new MockPerson(Map.of(
      "username", "mrrobot",
      "password", "hacker",
      "role", "ADMIN"
  ));
}
