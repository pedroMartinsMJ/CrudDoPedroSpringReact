package oi.github.pedroMartinsMJ.librayapi2.service;

import oi.github.pedroMartinsMJ.librayapi2.Repository.UserRepository;
import oi.github.pedroMartinsMJ.librayapi2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public User findByNameAndPassword(String name, String password){
        return userRepository.findByNameAndPassword(name, password);
    }
}
