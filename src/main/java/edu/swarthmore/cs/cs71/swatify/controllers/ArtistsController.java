package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.methods.AlbumsForArtistRequest;
import com.wrapper.spotify.methods.ArtistRequest;
import com.wrapper.spotify.models.Album;
import com.wrapper.spotify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.models.SwatifyArtist;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;


import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class ArtistsController {
    public ArtistsController() {
        path("/artists", () -> {
            get("/:id", (request, response) -> getArtist(request.params("id")), GsonUtil::toJson);
            patch("/:id", (request, response) -> updateArtist(GsonUtil.fromJson(SwatifyArtist.class, request.body())), GsonUtil::toJson);
            exception(IllegalArgumentException.class, (e, request, response) -> {
                response.status(400);
            });
        });
    }

    public static Artist getArtist(String spotifyId){

        final ArtistRequest request = SpotifyUtil.getSpotifyAPI().getArtist(spotifyId).build();

        try{
            final Artist requestedArtist = request.get();

            return requestedArtist;

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong...");
            System.out.println(e.getMessage());
        }

        return new Artist();
    }

    public static boolean createArtist(SwatifyArtist swatifyArtist) {
        return HibernateUtil.saveObject(swatifyArtist);
    }

    public static boolean updateArtist(SwatifyArtist swatifyArtist){
        return HibernateUtil.updateObject(swatifyArtist);
    }

    public static List<Album> getArtistAlbums (String spotifyId) {
        final AlbumsForArtistRequest albumsRequest = SpotifyUtil.getSpotifyAPI().getAlbumsForArtist(spotifyId).build();

        try{
            final List<Album> albums = (List<Album>) albumsRequest.get();
            return albums;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong...");
        }

        return new ArrayList<>();
    }
}
