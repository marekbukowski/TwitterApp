package sda.java6.twitter.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_users_generator")
    @SequenceGenerator(name="seq_users_generator", sequenceName="seq_users")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Message> userMessages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getUserMessages() {
        return userMessages;
    }

    public void setUserMessages(List<Message> userMessages) {
        this.userMessages = userMessages;
    }

    public User() {

    }


}
