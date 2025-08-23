package ru.practicum.shareit.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.practicum.shareit.shared.api.patch.PatchModule;

@Configuration
public class JacksonConfig {

  @Bean
  public PatchModule patchModule() {
    return new PatchModule();
  }
}
