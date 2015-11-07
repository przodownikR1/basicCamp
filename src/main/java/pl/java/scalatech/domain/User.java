package pl.java.scalatech.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends AbstractEntity{


    private  String firstname;
    private String lastName;
    private  String email;
    private String login;
    private String password;

   /* @ManyToMany(fetch = LAZY, cascade = { PERSIST, MERGE })
    @JoinTable(name = "ROLE", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "id") })
    @Valid
    private List<Role> roles;*/
    @OneToMany
    private List<Invoice> ownInvoice;


}
