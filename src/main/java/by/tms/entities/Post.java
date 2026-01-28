package by.tms.entities;

public class Post {
    private String title;
    private String description;
    private String img;


    public Post(String title, String description, String img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + "\n" +
                "Description: " + this.description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
