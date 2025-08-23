package ru.practicum.shareit.shared.api.patch;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class PatchModule
    extends SimpleModule {

  public PatchModule() {
    super("PatchModule");
    addDeserializer(FieldUpdate.class, new FieldUpdateDeserializer());
  }
}
