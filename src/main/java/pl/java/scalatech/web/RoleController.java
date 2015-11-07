package pl.java.scalatech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.java.scalatech.domain.Role;
import pl.java.scalatech.repository.RoleRepository;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(RoleController.URL)
public class RoleController extends AbstractRestController<Role>{
    protected static final String URL = "/roles";
    private final @NonNull RoleRepository roleRepository;

    @RequestMapping("/name/{name}")
    public ResponseEntity<Role> findByName(@PathVariable("name") String name) {
        Role loaded = roleRepository.findByRole(name).orElseThrow(() -> new IllegalArgumentException("id not exists"));
        return ResponseEntity.ok(loaded);
    }

    @Override
    protected String getURL() {
        return URL;
    }

}
