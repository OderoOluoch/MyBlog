package models;

import java.util.ArrayList;

public class Post {
    private String content;
    private static ArrayList<Post> mInstances = new ArrayList<>();

    public Post(String content){
        this.content = content;
        this.mInstances.add(this);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static ArrayList<Post> getAll(){
        return mInstances;
    }

    public static void cleaAllPosts(){
        mInstances.clear();
    }
}
