package com.digiLib.configClass;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect; 

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

@Configuration
public class RedisConfig {

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        // --- Configure Key Serializer ---
//        // For keys, typically use StringRedisSerializer
//        StringRedisSerializer stringSerializer = new StringRedisSerializer();
//        template.setKeySerializer(stringSerializer);
//        template.setHashKeySerializer(stringSerializer); // For hash keys
//
//        // --- Configure Value Serializer (JSON is recommended) ---
//        Jackson2JsonRedisSerializer<Object> jsonSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//
//        // Customize ObjectMapper for Jackson (important for polymorphic types like List<Book>)
//        ObjectMapper objectMapper = new ObjectMapper();
//        // This is crucial for deserializing complex objects like Lists of custom types
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        // This adds type info to JSON for proper deserialization
//        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
//
//        jsonSerializer.setObjectMapper(objectMapper);
//
//        template.setValueSerializer(jsonSerializer);
//        template.setHashValueSerializer(jsonSerializer); // For hash values
//
//        template.afterPropertiesSet();
//        return template;
//    }
	
    // You might already have this for your RedisTemplate
    // This ObjectMapper configuration is good for JSON serialization
    private ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        return objectMapper;
    }
    
    // This is the core part for setting TTLs
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        // 1. Create a default RedisCacheConfiguration
        //    This configuration applies to caches without explicit TTLs
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofSeconds(10)) // Default TTL for 10 minutes
            .disableCachingNullValues() // Don't cache null values
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
                new Jackson2JsonRedisSerializer<>(createObjectMapper(), Object.class)));


        // 2. Define specific TTLs for named caches
        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();

        // Cache for "users" with 5 minutes TTL
        cacheConfigurations.put("users", defaultCacheConfig.entryTtl(Duration.ofMinutes(5)));

        // Cache for "books" with 1 hour TTL
        cacheConfigurations.put("books", defaultCacheConfig.entryTtl(Duration.ofSeconds(10)));

        // Cache for "longRunningData" with 1 day TTL
        cacheConfigurations.put("longRunningData", defaultCacheConfig.entryTtl(Duration.ofDays(1)));


        // 3. Build the RedisCacheManager
        return RedisCacheManager.builder(connectionFactory)
            .cacheDefaults(defaultCacheConfig) // Apply default configuration
            .withInitialCacheConfigurations(cacheConfigurations) // Apply specific configurations
            .build();
    }
}
