package com.hoc.libraryfx.dao;

import com.hoc.libraryfx.model.Adherent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdherentDAO extends DAO<Adherent> {
    @Override
    protected List<Adherent> mapResultSet(ResultSet resultSet) throws SQLException {
        final List<Adherent> adherents = new ArrayList<>();
        while (resultSet.next()) {
            UUID id = resultSet.getObject("id", UUID.class);
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            LocalDate birthday = resultSet.getObject("birthday", LocalDate.class);
            boolean subscriptionPaid = resultSet.getBoolean("subscription_paid");

            // Create adherent and add it to the list
            Adherent adherent = new Adherent(id, firstName, lastName, birthday, subscriptionPaid);
            adherents.add(adherent);
        }

        return adherents;
    }

    @Override
    protected String getTableName() {
        return "adherents";
    }
}
