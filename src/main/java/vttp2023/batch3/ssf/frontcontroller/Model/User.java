package vttp2023.batch3.ssf.frontcontroller.Model;

import java.io.Serializable;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User implements Serializable {

    @Size(min = 2, message = "Please enter a valid username.")
    private String username;
    @Size(min = 2, message = "Please enter a valid password.")
    private String password;

    private boolean authenticated;

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JsonObject toJson() {

        return Json.createObjectBuilder()
                .add("username", this.getUsername())
                .add("password", this.getPassword())
                .build();
    }

}
