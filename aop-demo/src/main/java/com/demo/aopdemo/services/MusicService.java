package com.demo.aopdemo.services;

import java.util.List;

public interface MusicService {
    List<String> getAlbums(String artist);

    List<String> getAlbumSongs(String albumName);

    String getSongDetails(String songName) throws InterruptedException;
}
