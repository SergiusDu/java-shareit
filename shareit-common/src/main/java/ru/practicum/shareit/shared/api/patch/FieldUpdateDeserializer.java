package ru.practicum.shareit.shared.api.patch;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

import java.io.IOException;

public class FieldUpdateDeserializer
    extends JsonDeserializer<FieldUpdate<?>>
    implements ContextualDeserializer {
  private final JavaType valueType;

  public FieldUpdateDeserializer(JavaType valueType) {
    this.valueType = valueType;
  }

  public FieldUpdateDeserializer() {
    this.valueType = null;
  }

  @Override
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt,
                                              com.fasterxml.jackson.databind.BeanProperty property) {
    JavaType wrapperType = (property != null) ? property.getType() : ctxt.getContextualType();
    JavaType valueType = wrapperType.containedType(0);
    return new FieldUpdateDeserializer(valueType);
  }

  @Override
  public FieldUpdate<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    ObjectMapper objectMapper = (ObjectMapper) p.getCodec();
    JsonNode node = objectMapper.readTree(p);

    if (valueType == null) {
      return Absent.instance();
    }

    Object deserializedValue = objectMapper.treeToValue(node, valueType.getRawClass());
    return new Present<>(deserializedValue);
  }

  @Override
  public FieldUpdate<?> getNullValue(DeserializationContext ctxt) throws JsonMappingException {
    return Absent.instance();
  }
}
