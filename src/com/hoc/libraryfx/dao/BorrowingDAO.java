package com.hoc.libraryfx.dao;

import com.hoc.libraryfx.model.Borrowing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BorrowingDAO extends DAO<Borrowing> {
    @Override
    protected List<Borrowing> mapResultSet(ResultSet resultSet) throws SQLException {
        final List<Borrowing> borrowings = new ArrayList<>();
        while (resultSet.next()) {
            UUID id = resultSet.getObject("id", UUID.class);
            UUID bookId = resultSet.getObject("book_id", UUID.class);
            UUID adherentId = resultSet.getObject("adherent_id", UUID.class);
            LocalDateTime dateTime = resultSet.getObject("date_time", LocalDateTime.class);

            // Create borrowing and add it to the list
            Borrowing borrowing = new Borrowing(id, bookId, adherentId, dateTime);
            borrowings.add(borrowing);
        }

        return borrowings;
    }

    @Override
    protected String getTableName() {
        return "borrowings";
    }
}
