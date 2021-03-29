package com.accenture.javasystemproperties;

import com.thingworx.data.util.InfoTableInstanceFactory;
import com.thingworx.metadata.annotations.ThingworxServiceDefinition;
import com.thingworx.metadata.annotations.ThingworxServiceResult;
import com.thingworx.resources.Resource;
import com.thingworx.types.InfoTable;
import com.thingworx.types.collections.ValueCollection;
import com.thingworx.types.primitives.StringPrimitive;

public class JavaSystemPropertiesResource extends Resource {

  private static final long serialVersionUID = 1L;

  @ThingworxServiceDefinition(name = "getProperties", description = "", category = "", isAllowOverride = false, aspects = {"isAsync:false"})
  @ThingworxServiceResult(name = "result", description = "", baseType = "INFOTABLE", aspects = {"isEntityDataShape:true", "dataShape:FieldValuePair"})
  public InfoTable getProperties() throws Exception {
    InfoTable table = InfoTableInstanceFactory.createInfoTableFromDataShape("FieldValuePair");

    System.getProperties().forEach((key, value) -> {
      ValueCollection values = new ValueCollection();
      values.put("fieldName", new StringPrimitive(key.toString()));
      values.put("fieldValue", new StringPrimitive(value.toString()));
      table.addRow(values);
    });
    return table;
  }
}
