package com.todoapp.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException; 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response; 
import javax.ws.rs.core.UriBuilder;
import com.todoapp.domain.ToDo;
import com.todoapp.service.TodoService;

@Path("/todos")
public class TodoRestService {
@Inject
private TodoService todoService;
@POST
@Consumes("application/json")
public Response create(ToDo entity) {
    todoService.create(entity); return Response.created(
    UriBuilder.fromResource(TodoRestService.class) .path(String.valueOf(entity.getId())).build()).build();
    }
@GET
@Path("/{id:[0-9][0-9]*}") @Produces(MediaType.APPLICATION_JSON)
public ToDo lookupTodoById(@PathParam("id") long id) {
    ToDo todo = todoService.find(id); if (todo == null) {
throw new WebApplicationException(Response.Status.NOT_FOUND); }
    return todo; }
}
