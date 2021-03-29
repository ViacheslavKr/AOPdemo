package com.demo.aopdemo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    Logger logger = LoggerFactory.getLogger(MusicServiceImpl.class);

    public List<String> getAlbums(String artist) {
      //  logger.debug("Started execution: getAlbums");
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            result.add(artist + " " + "album " + i);

        }
      //  logger.debug("End execution of: getAlbums");
        return result;
    }

    public List<String> getAlbumSongs(String albumName) {
     //   logger.debug("Started execution: getAlbumSongs");

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            result.add(albumName + " " + "song " + i);

        }
      //  logger.debug("End execution of: getAlbumSongs");
        return result;
    }

    public String getSongDetails(String songName) throws InterruptedException {
       // logger.debug("Started execution: getSongDetails");
        final long start = System.currentTimeMillis();
        Thread.sleep(1000);

        //logger.debug("End execution of: getSongDetails");

        //logger.debug("getConcertDetails executed in {} ms", System.currentTimeMillis() - start);
        return "Some details about " + songName;
    }
}
