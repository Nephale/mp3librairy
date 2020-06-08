package com.hoc.libraryfx.dao;

import com.hoc.libraryfx.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthorDAO extends DAO<Author> {
    @Override
    protected List<Author> mapResultSet(ResultSet resultSet) throws SQLException {
        final List<Author> authors = new ArrayList<>();
        while (resultSet.next()) {
            UUID id = resultSet.getObject("id", UUID.class);
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            // Create author and add it to the list
            Author author = new Author(id, firstName, lastName);
            authors.add(author);
        }

        return authors;
    }

    @Override
    protected String getTableName() {
        return "authors";
    }
}
