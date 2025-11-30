package com.config;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class CorrelationIdFilter implements Filter {

    private static final String HEADER = "X-Correlation-Id";
    private static final String MDC_KEY = "correlationId";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String correlationId = req.getHeader(HEADER);

        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = UUID.randomUUID().toString();
        }

        MDC.put(MDC_KEY, correlationId);

        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader(HEADER, correlationId);

        chain.doFilter(request, response);

        MDC.remove(MDC_KEY);
    }
}
