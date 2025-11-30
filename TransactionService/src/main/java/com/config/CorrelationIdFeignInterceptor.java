package com.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;

@Configuration
public class CorrelationIdFeignInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CorrelationIdFeignInterceptor.class);
    private static final String MDC_KEY = "correlationId";
    private static final String HEADER = "X-Correlation-Id";

    @Bean
    public RequestInterceptor correlationIdInterceptor() {
        return (RequestTemplate template) -> {
            String correlationId = MDC.get(MDC_KEY);

            // fallback to servlet request if MDC is null
            if (correlationId == null || correlationId.isEmpty()) {
                ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (attrs != null) {
                    correlationId = attrs.getRequest().getHeader(HEADER);
                }
            }

            // generate new correlation ID if still null
            if (correlationId == null || correlationId.isEmpty()) {
                correlationId = UUID.randomUUID().toString();
            }

            // put correlation ID back to MDC for logging in this thread
            MDC.put(MDC_KEY, correlationId);

            // add header to Feign request
            template.header(HEADER, correlationId);

            LOGGER.info("Outgoing Feign request: method={}, url={}, headers={}, correlationId={}",
                    template.method(),
                    template.url(),
                    template.headers(),
                    correlationId
            );
        };
    }
}
