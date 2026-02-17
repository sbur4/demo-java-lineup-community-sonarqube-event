package com.lineup.java.demo.web.config;

import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
@RequiredArgsConstructor
public class JacksonConfig {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

//    private final Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper =  new ObjectMapper();
//        objectMapper.registerModule(new CustomModule());
        return objectMapper;
    }

//    @Bean
//    public JsonMapperBuilderCustomizer jacksonCustomizer() {
////        JsonMapper.Builder d = new JsonMapper.Builder();
//
//        return builder -> builder
//                .enable(SerializationFeature.INDENT_OUTPUT);
//    }

//    @Autowired
//    public ObjectMapper objectMapper(JsonMapperBuilderCustomizer builder) {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//
//        // Some other custom configuration for supporting Java 8 features
//        objectMapper.registerModule(new Jdk8Module());
//        objectMapper.registerModule(new JavaTimeModule());
//
//        // Use property
//        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
//
//        return objectMapper;
//    }

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
//        return builder -> {
//            // 1. Set Naming Strategy to Snake Case (user_name instead of userName)
//            builder.propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
//
//            // 2. Handle nulls (Exclude them from the JSON output)
//            builder.serializationInclusion(JsonInclude.Include.NON_NULL);
//
//            // 3. Global Date/Time Formatting
//            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT)));
//
//            // 4. Important for @Jacksonized / Lombok @Value
//            // This ensures Jackson can handle records and immutable DTOs correctly
//            builder.failOnUnknownProperties(false);
//
//            // 5. Java 25 support: ensure the module for new Date/Time API is registered
//            builder.findModulesViaServiceLoader(true);
//        };
//    }
}
