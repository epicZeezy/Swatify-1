package edu.swarthmore.cs.cs71.swatify;

import edu.swarthmore.cs.cs71.swatify.controllers.AlbumsController;
import edu.swarthmore.cs.cs71.swatify.controllers.ArtistsController;
import edu.swarthmore.cs.cs71.swatify.controllers.PostsController;
import edu.swarthmore.cs.cs71.swatify.controllers.UsersController;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        externalStaticFileLocation("src/main/resources/build");

        setRoutes();
    }

    public static void setRoutes() {
        path("/api/v1", () -> {
            new UsersController();
            new ArtistsController();
            new AlbumsController();
            new PostsController();

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }
}
