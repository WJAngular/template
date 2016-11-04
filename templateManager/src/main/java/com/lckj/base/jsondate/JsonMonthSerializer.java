
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
* @ClassName: JsonMonthSerializer 
* @Description: json年月处理类 
* @author: WUJING 
* @date :2016-06-10 上午11:02:22 
*
 */
public class JsonMonthSerializer extends JsonSerializer<Date> {
    
    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        String formattedDate = dateFormat.format(date);
        
        gen.writeString(formattedDate);
    }
}
