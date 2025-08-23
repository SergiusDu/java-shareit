// в shareit-app/src/test/java/ru/practicum/shareit/ModularityTests.java
package ru.practicum.shareit;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTests {

  ApplicationModules modules = ApplicationModules.of(ShareitAppApplication.class);

  @Test
  void verifyModules() {

    modules.verify();
  }

  @Test
  void createDocumentation() {
    new Documenter(modules)
        .writeDocumentation()
        .writeIndividualModulesAsPlantUml();
  }
}