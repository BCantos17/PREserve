package com.revature.data.impl;

import com.revature.beans.ReservationTable;
import com.revature.data.dao.TableDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository(value = "tableDAO")
public class TableDAOImpl implements TableDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public HashSet<ReservationTable> getAll() {
        return new HashSet<>(session.createCriteria(ReservationTable.class).list());
    }

    @Override
    public ReservationTable getById(int id) {
        return (ReservationTable) session.get(ReservationTable.class, id);
    }
}
