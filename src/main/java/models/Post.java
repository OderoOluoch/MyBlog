package models;

import java.util.ArrayList;

public class Post {
    private String content;
    private static ArrayList<Post> mInstances = new ArrayList<>();
    private boolean published;
    public Post(String content){
        this.content = content;
        this.published = false;
        this.mInstances.add(this);
    }

    public String getContent() {
        return content;
    }

    public static ArrayList<Post> getAll(){
        return mInstances;
    }

    public static void cleaAllPosts(){
        mInstances.clear();
    }
    public boolean getPublished(){
        return this.published;
    }
}
