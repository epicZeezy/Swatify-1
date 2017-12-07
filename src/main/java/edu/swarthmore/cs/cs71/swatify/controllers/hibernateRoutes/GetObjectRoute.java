package edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes;

import edu.swarthmore.cs.cs71.swatify.errors.NotFoundError;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.hibernate.Session;
import spark.Request;
import spark.Response;

public abstract class GetObjectRoute extends BaseRoute {

    @Override
    public Object doAction(Session session, Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        Object obj = session.get(getObjectClass(), id);
        return obj == null ? new NotFoundError(response,"Could not find the requested resource") : obj;
    }

    protected abstract Class<?> getObjectClass();
}