package beans;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeanTest {

    @Test
    public void testAlbum() {
        Album album = new Album();
        album.setId(1L);
        album.setName("The Dark Side of the Moon");
        album.setArtist("Pink Floyd");
        album.setRelease_date(LocalDate.of(1973, 3, 1));
        album.setSales(BigDecimal.valueOf(45000000));
        album.setGenre("ROCK");

        assertEquals(1L, album.getId());
        assertEquals("The Dark Side of the Moon", album.getName());
        assertEquals("Pink Floyd", album.getArtist());
        assertEquals(LocalDate.of(1973, 3, 1), album.getRelease_date());
        assertEquals(BigDecimal.valueOf(45000000), album.getSales());
        assertEquals("ROCK", album.getGenre());
    }

    @Test
    public void testAuthor() {
        Author author = new Author("Albert", "Einstein");
        assertEquals("Albert Einstein", author.getFullName());
    }

    @Test
    public void testQuote() {
        Author author = new Author("Albert", "Einstein");
        Quote quote = new Quote(author, "The difference between stupidity and genius is that genius has its limits.");
        assertEquals(author, quote.getAuthor());
        assertEquals("The difference between stupidity and genius is that genius has its limits.", quote.getContent());
    }

    @Test
    public void testMultipleInstancesOfQuotes() {
        Author author = new Author("Albert", "Einstein");

        List<Quote> quotes = new ArrayList<>(
                List.of(new Quote(author, "The difference between stupidity and genius is that genius has its limits."),
                        new Quote(author, "We can't solve today's problems with the mentality that created them."),
                        new Quote(author, "The world will not be destroyed by those who do evil, but by those who watch them without doing anything.")
                )
        );

        quotes.forEach(quote -> System.out.printf("%s: \"%s\"%n", quote.getAuthor().getFullName(), quote.getContent()));

    }

}