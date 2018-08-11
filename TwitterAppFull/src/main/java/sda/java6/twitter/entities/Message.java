package sda.java6.twitter.entities;

import javax.persistence.*;

@Entity
@Table(name = "tweets")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "seq_tweets_generator")
    @SequenceGenerator(name="seq_tweets_generator", sequenceName="seq_tweets")
    private Long id;

    @Column(name = "title")
    private String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column
    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Message() {

    }
}
