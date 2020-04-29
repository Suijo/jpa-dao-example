package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.time.ZoneId;
import java.util.Locale;

public class BookGenerator {
    public static Book GetRandomBook(){
        Faker faker = new Faker(new Locale("hu"));

        return Book.builder().isbn13(faker.code().isbn13()).author(faker.book().author()).title(faker.book().title())
                .format(faker.options().option(Book.Format.values())).publisher(faker.book().publisher())
                .publicationDate(faker.date().birthday(0,2000).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .pages(faker.number().numberBetween(10,10000)).available(faker.bool().bool())
                .build();
    }
}