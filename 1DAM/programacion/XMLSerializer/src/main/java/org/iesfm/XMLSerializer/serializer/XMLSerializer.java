package org.iesfm.XMLSerializer.serializer;

public interface XMLSerializer <T>{

    String toXml(T object);
}
