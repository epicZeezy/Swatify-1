package edu.swarthmore.cs.cs71.swatify.errors;

import spark.Response;

public class ForbiddenError extends Error {
    public ForbiddenError(Response response, String message) {
        super(response, message);
    }

    @Override
    protected int getStatus() {
        return 403;
    }
}
