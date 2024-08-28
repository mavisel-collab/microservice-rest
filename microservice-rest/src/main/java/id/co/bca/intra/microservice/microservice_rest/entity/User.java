package id.co.bca.intra.microservice.microservice_rest.entity;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
