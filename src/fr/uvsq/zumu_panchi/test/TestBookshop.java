package fr.uvsq.zumu_panchi.test;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println(this.b.getStocks());
        assertEquals(this.b.getStocks().keySet().size(), 4);
    }

    @Test
    void testSeedBooks() throws IOException {
        this.b.seedComicBooks("books.csv");
        System.out.println(this.b.getStocks());
        assertEquals(this.b.getStocks().keySet().size(), 1);
    }
}
