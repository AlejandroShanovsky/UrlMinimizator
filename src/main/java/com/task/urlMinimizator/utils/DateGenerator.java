package com.task.urlMinimizator.utils;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateGenerator {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(DateGenerator.class);
    private Calendar calendar;

    public DateGenerator() {
        this.calendar = Calendar.getInstance();
    }

    public Date createUrlEndingTime(Date dateOfCreation, int countOfDays) {
        calendar.setTime(dateOfCreation);
        calendar.add(Calendar.DATE, countOfDays);
        LOGGER.info("Date of url ending successfully created.");
        return calendar.getTime();
    }
}
