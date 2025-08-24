package ru.practicum.shareit;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModulithDocs {
  @Test
  void writeDocs() {
    var modules = ApplicationModules.of(ShareitAppApplication.class);
    new Documenter(modules, Documenter.Options.defaults().withOutputFolder("../docs/modulith"))
        .writeDocumentation()
        .writeAggregatingDocument()
        .writeModulesAsPlantUml()
        .writeIndividualModulesAsPlantUml();
  }
}
