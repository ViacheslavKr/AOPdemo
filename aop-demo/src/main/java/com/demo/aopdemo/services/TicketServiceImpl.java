package com.demo.aopdemo.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TicketServiceImpl implements TicketService {

    Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    public List<String> getArtistConcerts(String artist) {
    //    logger.debug("Started execution: getArtistConcerts");

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            result.add(artist + " " + "concert " + i + " " + between(LocalDate.now(), LocalDate.of(2023, 12, 31)));
        }
    //    logger.debug("End execution of: getArtistConcerts");
        return result;
    }

    @Override
    public String getConcertDetails(long concertId) {
    //    logger.debug("Started execution: getConcertDetails");
        final long start = System.currentTimeMillis();

        String result = "Some very helpful details for concert with id"  + concertId;


   //     logger.debug("End execution of: getConcertDetails");
    //   logger.debug("getConcertDetails executed in {} ms", System.currentTimeMillis() - start);
        return result;
    }


    public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
