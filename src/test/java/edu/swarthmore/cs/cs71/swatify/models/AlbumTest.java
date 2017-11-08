package edu.swarthmore.cs.cs71.swatify.models;

import org.junit.Test;

import java.sql.Timestamp;
import static org.junit.Assert.assertEquals;

public class AlbumTest {

  @Test
    public void setAndGetCorrectAlbumFields(){

      Album collegeDropouts = new Album();
      Timestamp genericReleaseDate = new Timestamp(0L);
      collegeDropouts.setReleaseDate(genericReleaseDate);
      collegeDropouts.setSpotifyID("47b7v7e");
      collegeDropouts.setTitle("College Dropouts");

      assertEquals(genericReleaseDate, collegeDropouts.getReleaseDate());
      assertEquals("47b7v7e", collegeDropouts.getSpotifyID());
      assertEquals("College Dropouts", collegeDropouts.getTitle());
  }
}
