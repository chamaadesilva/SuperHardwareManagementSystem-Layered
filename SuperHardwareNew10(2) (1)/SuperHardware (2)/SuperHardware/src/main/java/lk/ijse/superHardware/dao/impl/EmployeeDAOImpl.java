package lk.ijse.superHardware.dao.impl;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.EmployeeDAO;
import lk.ijse.superHardware.dto.EmployeeDto;
import lk.ijse.superHardware.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

  public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean save(final Employee entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO employee VALUES(?, ?, ?)",
                entity.getEmp_id(),entity.getEmp_name(),entity.getAddress());
    }

    @Override
    public boolean update(final Employee entity) throws SQLException {
        return SQLUtil.execute("UPDATE employee SET emp_name = ?, address = ? WHERE emp_id = ?",
                entity.getEmp_name(),entity.getAddress(),entity.getEmp_id());
    }

    @Override
    public boolean delete(String emp_id) throws SQLException {
        return SQLUtil.execute("DELETE FROM employee WHERE emp_id = ?" ,emp_id);
    }

    @Override
    public List<EmployeeDto> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee");
        List<EmployeeDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String emp_id = resultSet.getString(1);
            String emp_name = resultSet.getString(2);
            String address = resultSet.getString(3);

            var dto = new EmployeeDto(emp_id, emp_name, address);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public EmployeeDto search(String emp_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE emp_id = ?",emp_id);
        resultSet.next();
        return new EmployeeDto(emp_id +"",resultSet.getString("emp_name"),resultSet.getString("address"));
    }


    }
