package br.com.thrillio.dao;

import br.com.thrillio.DataStore;
import br.com.thrillio.entities.User;

public class UserDao {
    public User[] getUsers() {
            return DataStore.getUsers();
    }
}
