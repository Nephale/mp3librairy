package com.hoc.libraryfx.dao;

import com.hoc.libraryfx.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookDAO extends DAO<Book> {
    @Override
    protected List<Book> mapResultSet(ResultSet resultSet) throws SQLException {
        final List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            UUID id = resultSet.getObject("id", UUID.class);
            UUID authorId = (UUID) resultSet.getObject("author_id");
            String isbn13 = resultSet.getString("isbn13");
            String title = resultSet.getString("title");
            String summary = resultSet.getString("summary");

            // Create book and add it to the list
            Book book = new Book(id, authorId, isbn13, title, summary);
            books.add(book);
        }

        return books;
    }

    public List<Book> getByAuthor(UUID authorId) {
        return getBy("author_id", authorId);
    }

    public Optional<Book> getByIsbn13(String isbn13) {
        return getOneBy("isbn13", isbn13);
    }

    public List<Book> getByTitleLike(String title) {
        // Initial list
        final List<Book> entities = new ArrayList<>();

        String query = "SELECT * FROM books WHERE title LIKE '%' || ? || '%'";

        try (Connection conn = Database.getInstance().getConn();
             PreparedStatement statement = conn.prepareStatement(query);
        ) {
            // Prepare statement
            statement.setObject(1, title);

            // Execute query, map, and create the optional
            ResultSet resultSet = statement.executeQuery();
            entities.addAll(mapResultSet(resultSet));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    protected String getTableName() {
        return "books";
    }
}
