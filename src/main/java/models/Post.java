package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {
    private String content;
    private static ArrayList<Post> mInstances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;

    public Post(String content){
        this.content = content;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        this.mInstances.add(this);
        this.id = mInstances.size();
    }

    public String getContent() {
        return content;
    }

    public static ArrayList<Post> getAll(){
        return mInstances;
    }

    public static void clearAllPosts(){
        mInstances.clear();
    }
    public boolean getPublished(){
        return this.published;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public int getId(){
        return id;
    }
     public static Post findById(int id){
        return mInstances.get(id-1);
     }

    public void update(String content) {
        this.content = content;
    }
    public void deletePost(){
        mInstances.remove(id-1); //same reason
    }
}
