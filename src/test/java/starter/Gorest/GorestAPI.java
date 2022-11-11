package starter.Gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class GorestAPI {
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
    public static final String GET_LIST_TODOS_PARAM_ID = URL+"/public/v2/todos?id={id}";
    public static final String GET_LIST_TODOS_PARAM_ID_KAPITAL = URL+"/public/v2/todos?ID={ID}";
    public static final String GET_LIST_TODOS_PARAM_ID_KEY_GO = URL+"/public/v2/todos?ID={ID}&key&go";
    public static final String GET_LIST_TODOS_PARAM_ID_KEY_GO_KAPITAL = URL+"/public/v2/todos?ID={ID}&KEY&GO";
    public static final String GET_LIST_TODOS_INVALID = URL+"/public/v2/todosDA";
    public static final String PUT_UPDATE_TODOS = URL+"/public/v2/todos/{id}";
    public static final String PATCH_TODOS = URL+"/public/v2/comments/{id}";
    public static final String DELETE_TODOS = URL+"/public/v2/comments/{id}";

    @Step("Get list users")
    public void getListUsers (int page){SerenityRest.given().pathParam("page",page);}
    @Step("Get list posts")
    public void getListPosts (int page){SerenityRest.given().pathParam("page",page);}
    @Step("Get list comments")
    public void getListComments (int page){SerenityRest.given().pathParam("page",page);}
    @Step("Get list todos")
    public void getListTodos (File page){SerenityRest.given().pathParam("page",page);}
    @Step("Get list todos param")
    public void getListTodosParam (int id, File json)
    {SerenityRest.given().pathParam("id",id);
    }
    @Step("Get list todos param kapital")
    public void getListTodosParamKapital (int ID, File json)
    {SerenityRest.given().pathParam("ID",ID);
    }
    @Step("Get list todos")
    public void setGetListTodosInvalid (File id){SerenityRest.given().pathParam("id",id);}
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
    @Step("Delete posts with invalid id")
    public void deletePostsWithInvalidId(String id){SerenityRest.given().pathParam("id",id);}
    @Step("Delete comments")
    public void deleteComments(int id){SerenityRest.given().pathParam("id",id);}
    @Step("Delete todos")
    public void deleteTodos(int id){SerenityRest.given().pathParam("id",id);}

}
