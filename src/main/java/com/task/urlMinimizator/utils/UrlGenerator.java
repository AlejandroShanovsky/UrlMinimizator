package com.task.urlMinimizator.utils;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.LinkedHashSet;
import java.util.Random;

@Component
public class UrlGenerator {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(UrlGenerator.class);
    private LinkedHashSet<Long> uniqueIdSet;
    private Random random;

    public UrlGenerator() {
        this.uniqueIdSet = new LinkedHashSet<>();
        this.random = new Random(Long.MAX_VALUE);
    }

    public String generateShortUrl() {
        String shortUrl = "http://loca.ly/";
        long uniqueIdentifier;
        while (true) {
            uniqueIdentifier = random.nextLong();
            if (!uniqueIdSet.contains(uniqueIdentifier)) {
                uniqueIdSet.add(uniqueIdentifier);
                break;
            }
        }
        LOGGER.info("Short url successfully created.");
        return shortUrl + uniqueIdentifier;
    }
}
