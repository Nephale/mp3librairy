package com.hoc.libraryfx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class DAO<T> {
    public List<T> getAll() {
        // Initial list
        final List<T> entities = new ArrayList<>();

        // Prepare statement
        String query = "SELECT * FROM $table"
                .replace("$table", getTableName());

        try (Connection conn = Database.getInstance().getConn();
             PreparedStatement statement = conn.prepareStatement(query);
        ) {

            ResultSet resultSet = statement.executeQuery();
            entities.addAll(mapResultSet(resultSet));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    public Optional<T> getById(UUID id) {
        return getOneBy("id", id);
    }

    protected List<T> getBy(String column, Object param) {
        // Initial list
        final List<T> entities = new ArrayList<>();

        String query = "SELECT * FROM $table WHERE $column = ?"
                .replace("$table", getTableName())
                .replace("$column", column);

        try (Connection conn = Database.getInstance().getConn();
             PreparedStatement statement = conn.prepareStatement(query);
        ) {
            // Prepare statement
            statement.setObject(1, param);

            // Execute query, map, and create the optional
            ResultSet resultSet = statement.executeQuery();
            entities.addAll(mapResultSet(resultSet));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    protected Optional<T> getOneBy(String column, Object param) {
        List<T> result = getBy(column, param);
        if (result.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(result.get(0));
        }
    }

    protected abstract List<T> mapResultSet(ResultSet resultSet) throws SQLException;

    protected abstract String getTableName();
}
