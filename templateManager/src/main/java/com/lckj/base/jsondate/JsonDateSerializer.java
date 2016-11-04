
package com.lckj.base.jsondate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 
* @ClassName: JsonDateSerializer 
* @Description: json日期处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:02:11 
*
 */
public class JsonDateSerializer extends JsonSerializer<Date> {
    
    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        
        gen.writeString(formattedDate);
    }
}
