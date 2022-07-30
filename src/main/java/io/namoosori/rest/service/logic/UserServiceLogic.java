package io.namoosori.rest.service.logic;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import io.namoosori.rest.store.UserStore;
import io.namoosori.rest.store.logic.UserStoreLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor//Lombok
public class UserServiceLogic implements UserService {

    private final UserStore userStore;
    //final을 붙여야함. -> 무조건 선언과 동시에 초기화 해야함.


//    public UserServiceLogic(UserStore userStore) {
//        this.userStore = userStore;
//    }

    @Override
    public String register(User newUser) {
        return this.userStore.create(newUser);
    }

    @Override
    public void modify(User newUser) {
        userStore.update(newUser);
    }

    @Override
    public void remote(String id) {
        userStore.delete(id);
    }

    @Override
    public User find(String id) {
        return userStore.retrieve(id);
    }

    @Override
    public List<User> findAll() {
        return userStore.retrieveAll();
    }
}
