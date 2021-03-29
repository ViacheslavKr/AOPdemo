package com.demo.aopdemo.services;

import java.util.List;

public interface TicketService {
    List<String> getArtistConcerts(String artist);
    String getConcertDetails(long concertId);
}
