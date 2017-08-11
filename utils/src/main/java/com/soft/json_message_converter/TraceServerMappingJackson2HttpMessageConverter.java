package com.soft.json_message_converter;

import com.fasterxml.jackson.core.JsonGenerator;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>ClassName:     TraceServerMappingJackson2HttpMessageConverter
 * <p>Description:   业务数据json中增加错误码消息头
 * <p>Version        V1.0
 */
class TraceServerMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    @Override
    protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
        if(object instanceof ArrayList) {
            List list = (List) object;
            if(!list.isEmpty()) {
                if (list.get(0) instanceof SwaggerResource) {
                    super.writePrefix(generator, object);
                    return;
                }
            }
        }

        if(object instanceof Json || object instanceof SecurityConfiguration || object instanceof UiConfiguration) {
            super.writePrefix(generator, object);
            return;
        }

        generator.writeRaw("{\"resultCode\": 0,\n" +
                "\"resultMsg\": \"\",\n" +
                "\"data\":");

        super.writePrefix(generator, object);
    }

    @Override
    protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
        if(object instanceof ArrayList) {
            List list = (List) object;
            if(!list.isEmpty()) {
                if (list.get(0) instanceof SwaggerResource) {
                    super.writeSuffix(generator, object);
                    return;
                }
            }
        }

        if(object instanceof Json || object instanceof SecurityConfiguration || object instanceof UiConfiguration) {
            super.writeSuffix(generator, object);
            return;
        }

        generator.writeRaw("}");

        super.writeSuffix(generator, object);
    }
}
