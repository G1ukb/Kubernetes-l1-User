package restMain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/hello")
    public String hello() {
        return "hi, i am userRepo";
    }

    @GetMapping("/users")
    public User greeting(@RequestParam(value = "id") int id) {
        return userRepo.findById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setAmount(String.valueOf(0));
        return userRepo.save(user);
    }

    @DeleteMapping("/users")
    public void deleteUser(@RequestParam(value = "id") int id) {
        userRepo.delete(userRepo.findById(id));
    }

    @PutMapping("/users")
    public User updateUser(@RequestParam(value = "id") int id, @RequestBody User user) {
        return userRepo.save(userRepo.findById(id));
    }

    @PutMapping("/users/upAmount")
    public User upUserAmount(@RequestParam(value = "id") int id) {
        User user = userRepo.findById(id);
        user.setAmount(String.valueOf(Integer.parseInt(user.getAmount()) + 1));
        return userRepo.save(user);
    }

    @PutMapping("/users/downAmount")
    public User downUserAmount(@RequestParam(value = "id") int id) {
        User user = userRepo.findById(id);
        user.setAmount(String.valueOf(Integer.parseInt(user.getAmount()) - 1));
        return userRepo.save(user);
    }

}