package com.demo.aopdemo;

import com.demo.aopdemo.services.MusicService;
import com.demo.aopdemo.services.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopDemoApplicationTests {
    @Autowired
    MusicService musicService;

    @Autowired
    TicketService ticketService;

    @Test
    void getConcertList() {
        ticketService.getArtistConcerts("Tessa Violet");
    }


    @Test
    void testMusicService() throws InterruptedException {

        musicService.getAlbums("Green Day");
        musicService.getAlbumSongs("Harmonica Andromeda");
        musicService.getSongDetails("Reamon Supergirl");
        ticketService.getArtistConcerts("Tessa Violet");
        ticketService.getConcertDetails(1013L);
    }


    @Test
    void contextLoads() {
    }




}
