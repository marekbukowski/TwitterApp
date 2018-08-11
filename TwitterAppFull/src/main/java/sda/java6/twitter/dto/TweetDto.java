package sda.java6.twitter.dto;

public class TweetDto {

    private int id;

    private String title;

    private String message;



    public TweetDto(int id, String title, String message, int userId) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.userId = userId;
    }

    public TweetDto() {

    }

    public int getId() {
        return id;
    }

    public boolean isNew() {
        if (id==0) {
            return true;
        } else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public int getUserId() {
        return userId;
    }

    private int userId;
}
