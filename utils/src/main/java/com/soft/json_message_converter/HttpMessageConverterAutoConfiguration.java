package com.soft.json_message_converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * <p>ClassName:     HttpMessageConverterAutoConfiguration
 * <p>Description:   注册http消息处理
 * <p>Version        V1.0
 */
@Configuration
public class HttpMessageConverterAutoConfiguration {
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {

        return new TraceServerMappingJackson2HttpMessageConverter();
    }
}
