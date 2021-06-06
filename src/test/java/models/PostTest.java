package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        Post.clearAllPosts();
    }

    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception{
        Post post = new Post("Day 1:Into");
        assertEquals(true,post instanceof Post);
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception{
        Post post = new Post("Day 1: Intro");
        assertEquals("Day 1: Intro",post.getContent());
    }
    @Test
    public void AllPostsAreCorrectlyReturned_true(){
        Post post = new Post("Day 1: Intro");
        Post secondPost = new Post("How to pair successfully");
        assertEquals(2,Post.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true(){
        Post post = new Post("Day 1: Intro");
        Post secondPost = new Post("How to pair successfully");
        assertTrue(Post.getAll().contains(post));
        assertTrue(Post.getAll().contains(secondPost));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false(){
        Post myPost = new Post("Day: Intro");
        assertEquals(false,myPost.getPublished());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Post myPost = setUpNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(),myPost.getCreatedAt().getDayOfWeek());

    }

    public Post setUpNewPost(){
        return new Post("Day 1: Intro");
    }

    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception{
        Post.clearAllPosts();
        Post myPost = new Post("Day 1: Intro");
        assertEquals(1,myPost.getId());
    }

    @Test
    public void findReturnsCorrectPost() throws Exception{
        Post post = setUpNewPost();
        assertEquals(1,Post.findById(post.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExixits() throws Exception{
        Post post = setUpNewPost();
        Post otherPost = new Post("How to pair successfully");
        assertEquals(2,Post.findById(otherPost.getId()).getId());
    }

    @Test
    public void updateChangesPostContent() throws Exception {
        Post post = setUpNewPost();
        String formerContent = post.getContent();
        LocalDateTime formerDate = post.getCreatedAt();
        int formerId = post.getId();

        post.update("Android: Day 40");

        assertEquals(formerId, post.getId());
        assertEquals(formerDate, post.getCreatedAt());
        assertNotEquals(formerContent, post.getContent());
    }

    @Test
    public void deleteDeletesASpecificPost() throws Exception {
        Post post = setUpNewPost();
        Post otherPost = new Post("How to pair successfully");
        post.deletePost();
        assertEquals(1, Post.getAll().size()); //one is left
        assertEquals(Post.getAll().get(0).getId(), 2); //the one that was deleted has the id of 2. Why do we care?
    }

    @Test
    public void deleteAllPostsDeletesAllPosts() throws Exception {
        Post post = setUpNewPost();
        Post otherPost = setUpNewPost();

        Post.clearAllPosts();
        assertEquals(0, Post.getAll().size());
    }
}