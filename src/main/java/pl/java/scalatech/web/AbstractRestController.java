package pl.java.scalatech.web;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.base.Preconditions;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.AbstractEntity;
@Slf4j
public abstract class AbstractRestController<T extends AbstractEntity> {
    @Autowired
    private JpaRepository<T, Long> jpaRepository;

    @RequestMapping("")
    ResponseEntity<List<T>> objects() {
        return ok(jpaRepository.findAll());
    }

    @RequestMapping(name="/{id}",produces = "application/json; charset=utf-8")
    ResponseEntity<T> findObjectById(@PathVariable Long id) {
        return ok(findProductByIdFromRepo(id));
    }

    private T findProductByIdFromRepo(Long id) {
        T t = Preconditions.checkNotNull(jpaRepository.getOne(id));
        log.info("++++++++++++ {}",t);
        return t;
    }

    @RequestMapping(name = "/{id}", method = PUT,produces = "application/json; charset=utf-8")
    ResponseEntity<T> updateObjectById(@RequestBody T t, @PathVariable("id") Long id) {
        findProductByIdFromRepo(id);
        t.setId(id);
        return ok(jpaRepository.save(t));
    }

    @RequestMapping(method = POST,produces = "application/json; charset=utf-8")
    ResponseEntity<Void> createObject(@RequestBody T t, UriComponentsBuilder uriBuilder) {
        log.info("+++++++++++++++++++  {}",t);
        T loaded = jpaRepository.save(t);
        log.info("++++  saved {}",loaded);
        URI uri = uriBuilder.path(getURL() + "/{id}").buildAndExpand(loaded.getId()).toUri();
        return created(uri).build();
    }

    @RequestMapping(name = "/{id}", method = DELETE,produces = "application/json; charset=utf-8")
    ResponseEntity<T> deleteObject(@PathVariable("id") Long id) {
        T loaded = findProductByIdFromRepo(id);
        return ResponseEntity.ok(loaded);
    }

   protected abstract String getURL();
}
