package beans;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeanTest {

    @Test
    public void testGetAlbumId() {
        Album album = new Album();
        album.setId(1L);
        assertEquals(1L, album.getId());
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

        quotes.forEach(quote -> {
            System.out.println(String.format("%s: \"%s\"", quote.getAuthor().getFullName(), quote.getContent()));
        });

    }

}