package lk.ijse.superHardware.dao;

import lk.ijse.superHardware.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO{

    boolean save(Employee dto) throws SQLException;

    boolean update(Employee dto) throws SQLException;

    boolean delete(String id)throws SQLException;

    List<T> getAll() throws SQLException;

    T search(String id) throws SQLException;



}
