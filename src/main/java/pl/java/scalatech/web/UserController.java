package pl.java.scalatech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.UserRepository;
import pl.java.scalatech.service.user.UserService;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
@RequestMapping(UserController.URL)
public class UserController extends AbstractRestController<User>{
    protected static final String URL = "/users";
    private @NonNull final UserService userService;
    private @NonNull final UserRepository userRepository;


    @RequestMapping("/login/{login}")
    public ResponseEntity<User> findByLogin(@PathVariable("login") String login) {
        User loaded = userRepository.findByLogin(login).orElseThrow(() -> new IllegalArgumentException("id not exists"));
        return ResponseEntity.ok(loaded);
    }

    @Override
    protected String getURL() {
        return URL;
    }

}


