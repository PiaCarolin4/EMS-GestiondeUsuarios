package cl.duocuc.piperalta.ecomarketspa.controller;

import cl.duocuc.piperalta.ecomarketspa.controller.response.MessageResponse;
import cl.duocuc.piperalta.ecomarketspa.domain.User;
import cl.duocuc.piperalta.ecomarketspa.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    List<User> users;

    public UserController() {
        users = UserRepository.findAll();
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<MessageResponse> createUser(@RequestBody User request) {
        String id = request.getId();
        for (User user : users) {
            if (user.getId().equals(id)) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(new MessageResponse("Error: usuario existente"));
            }
        }
        users.add(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                users.remove(user);
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .body(new MessageResponse("Usuario eliminado"));
            }
        }
        return ResponseEntity.notFound().build();
    }

}


