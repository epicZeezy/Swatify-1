package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class UsersController {
    public UsersController() {
        path("/users", () -> {
            get("/:id", (request, response) -> getUser(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            post("", (request, response) -> createUser(GsonUtil.fromJson(User.class, request.body())),  GsonUtil::toJson);

            patch("/:id", (request, response) -> updateUser(GsonUtil.fromJson(User.class, request.body())), GsonUtil::toJson);

            delete("/:id", (request, response) -> deleteUser(Integer.parseInt(request.params("id"))), GsonUtil::toJson);
        });
    }

    public static User getUser(int id) {
        return HibernateUtil.getObjectById(User.class, id);
    }

    public static boolean createUser(User user) {
        return HibernateUtil.saveObject(user);
    }

    public static boolean updateUser(User user) {
        return HibernateUtil.updateObject(user);
    }

    public static boolean deleteUser(int id) {
        return HibernateUtil.deleteObject(User.class, id);
    }

}
