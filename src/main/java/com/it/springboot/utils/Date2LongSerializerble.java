package com.it.springboot.utils;/**
 * Created by sunrise on 2018/9/5.
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName Date2LongSerializerble
 * @Description
 * @Author sunrise
 * @Date 2018/9/5 20:59
 * @Version 1.0
 */
public class Date2LongSerializerble extends JsonSerializer<Date>{

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeNumber((date.getTime() /1000));
    }
}
