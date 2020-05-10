package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uvsq.zumu_panchi.model.Bookshop;

class TestBookshop {

    private Bookshop b;
    
    @BeforeEach
    void setUp() throws Exception {
        b = new Bookshop();
    }

    @Test
    void testSeedComicBooks() throws IOException {
        this.b.seedComicBooks("comic_books.csv");
        
    }

    @Test
    void testSeedBooks() throws IOException {
        this.b.seedComicBooks("books.csv");
        
    }
}
