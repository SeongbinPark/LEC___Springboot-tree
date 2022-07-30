package io.namoosori.rest.store;

import io.namoosori.rest.entity.User;

import java.util.List;

public interface UserStore {

    String create(User newUser);

    void update(User nesUser);

    void delete(String id);

    User retrieve(String id);

    List<User> retrieveAll();

}
