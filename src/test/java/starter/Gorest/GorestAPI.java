package starter.Gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class GorestAPI {
    public static String USER_ID;
    public static final String URL = "https://gorest.co.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static final String POST_CREATE_USERS = URL+"/public/v2/users";
    public static final String GET_LIST_USERS = URL+"/public/v2/users?page={page}";
    public static final String GET_SINGLE_USERS = URL+"/public/v2/users/{id}";
    public static final String PUT_UPDATE_USERS = URL+"/public/v2/users/{id}";
    public static final String DELETE_USERS = URL+"/public/v2/users/{id}";
    public static final String POST_CREATE_POSTS = URL+"/public/v2/posts";
    public static final String GET_LIST_POSTS = URL+"/public/v2/posts?page={page}";
    public static final String GET_SINGLE_POSTS = URL+"/public/v2/posts/{id}";
    public static final String PUT_UPDATE_POSTS = URL+"/public/v2/posts/{id}";
    public static final String DELETE_POSTS = URL+"/public/v2/posts/{id}";
    public static final String POST_CREATE_COMMENTS = URL+"/public/v2/comments";
    public static final String GET_LIST_COMMENTS = URL+"/public/v2/comments?page={page}";
    public static final String GET_SINGLE_COMMENTS = URL+"/public/v2/comments/{id}";
    public static final String PUT_UPDATE_COMMENTS = URL+"/public/v2/comments/{id}";
    public static final String DELETE_COMMENTS = URL+"/public/v2/comments/{id}";
    public static final String POST_CREATE_TODOS = URL+"/public/v2/todos";
    public static final String GET_LIST_TODOS = URL+"/public/v2/todos?page={page}";
    public static final String GET_SINGLE_TODOS = URL+"/public/v2/todos/{id}";
    public static final String PUT_UPDATE_TODOS = URL+"/public/v2/todos/{id}";
    public static final String DELETE_TODOS = URL+"/public/v2/todos/{id}";

    @Step("Get list users")
    public void getListUsers (int page){SerenityRest.given().pathParam("page",page);}
    @Step("Get list posts")
    public void getListPosts (int page){SerenityRest.given().pathParam("page",page);}
    @Step("Get list comments")
    public void getListComments (int page){SerenityRest.given().pathParam("page",page);}
    @Step("Get list todos")
    public void getListTodos (int page){SerenityRest.given().pathParam("page",page);}
    @Step("Get single users")
    public void getSingleUsers (int id){SerenityRest.given().pathParam("id",id);}
    @Step("Get single posts")
    public void getSinglePosts (int id){SerenityRest.given().pathParam("id",id);}
    @Step("Get single comments")
    public void getSingleComments (int id){SerenityRest.given().pathParam("id",id);}
    @Step("Get single todos")
    public void getSingleTodos (int id){SerenityRest.given().pathParam("id",id);}
    @Step("Post create users")
    public void postCreateUsers (File json){SerenityRest.given().contentType(ContentType.JSON).body(json);}
    @Step("Post create posts")
    public void postCreatePosts (File json){SerenityRest.given().contentType(ContentType.JSON).body(json);}
    @Step("Post create comments")
    public void postCreateComments (File json){SerenityRest.given().contentType(ContentType.JSON).body(json);}
    @Step("Post create todos")
    public void postCreateTodos (File json){SerenityRest.given().contentType(ContentType.JSON).body(json);}
    @Step("Put update users")
    public void putUpdateUsers(int id,File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);}
    @Step("Put update posts")
    public void putUpdatePosts(int id,File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);}
    @Step("Put update posts with invalid id")
    public void putUpdatePostsWithInvalidId(String id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);}
    @Step("Put update comments")
    public void putUpdateComments(int id,File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);}
    @Step("Put update todos")
    public void putUpdateTodos(int id,File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);}
    @Step("Delete users")
    public void deleteUsers(int id){SerenityRest.given().pathParam("id",id);}
    @Step("Delete posts")
    public void deletePosts(int id){SerenityRest.given().pathParam("id",id);}
    @Step("Delete posts with invalid id Int")
    public void deletePostsWithInvalidIdInt(int id){SerenityRest.given().pathParam("id",id);}
    @Step("Delete comments")
    public void deleteComments(int id){SerenityRest.given().pathParam("id",id);}
    @Step("Delete todos")
    public void deleteTodos(int id){SerenityRest.given().pathParam("id",id);}

    @Step("Get list posts invalid page with character & special character")
    public void getListPostsInvalidPage(String page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get single post with invalid id by alphabet")
    public void getSinglePostInvalidPage(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Put update comments invalid id")
    public void putUpdateCommentInvalidId(int id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);}

    @Step("Delete Post with Invalid Id")
    public void deletePostsWithInvalidId(String id) {
        SerenityRest.given().pathParam("id",id);
    }
}
