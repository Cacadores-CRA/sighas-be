package cacadores.ifal.sighas.api.v1.app_management.model.entity.user;

import org.hibernate.validator.constraints.UUID;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cacadores.ifal.sighas.api.v1.app_management.model.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(
    name = "tab_user",
    uniqueConstraints = {
        @UniqueConstraint(name="tab_user_un_email", columnNames = "email")
    }
)
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private HashSet<UserRole> roles;

    public User(String name, String surname, String email, String password, HashSet<UserRole> roles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.roles = roles;

    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
            .map( role -> new SimpleGrantedAuthority(role.name()) )
            .collect(Collectors.toList());
    }
    
    @Override
    public String getPassword() {
        return this.password;
    }
    
    @Override
    public String getUsername() {
        return this.email;
    }

    public HashSet<UserRole> getRoles() {
        return this.roles;
    }
}
