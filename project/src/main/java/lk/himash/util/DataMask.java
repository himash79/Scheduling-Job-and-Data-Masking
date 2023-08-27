package lk.himash.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lk.himash.model.User;

import java.io.IOException;

public class DataMask extends JsonSerializer {
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        String maskedValue = null;
        if(o.toString().contains("+") || o.toString().contains("-")) {
            maskedValue = o.toString().replaceAll("\\w(?=\\w{2})","x");
        } else {
            maskedValue = o.toString().replaceAll("\\w(?=\\w{0})","x");
        }
        jsonGenerator.writeString(maskedValue);
    }
}
