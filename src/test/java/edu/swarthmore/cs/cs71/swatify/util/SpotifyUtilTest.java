package edu.swarthmore.cs.cs71.swatify.util;

import org.junit.Assert;
import org.junit.Test;

public class SpotifyUtilTest {

    @Test
    public void shouldPrintAlbumResults(){
        SpotifyUtil spotifyUtil = new SpotifyUtil();
        boolean foundAlbum = spotifyUtil.searchAlbum("Life of Pablo");
        Assert.assertEquals(foundAlbum, true);
    }
}
