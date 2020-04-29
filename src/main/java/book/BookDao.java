package book;

import book.model.Book;
import jpa.GenericJpaDao;


import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class BookDao extends GenericJpaDao<Book> {
    Optional<Book> findByIsbn13(String isbn13){
        try {
            return Optional.of(entityManager.createQuery("SELECT b FROM Book b WHERE b.isbn13 = :isbn13", Book.class)
                    .setParameter("isbn13", isbn13)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b ORDER BY b.title", Book.class)
                .getResultList();
    }
}