package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
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
}