package lk.ijse.superHardware.model;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.db.DbConnection;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.EmployeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    public boolean saveEmployee(final EmployeeDto dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO employee VALUES(?, ?, ?)",dto.getEmp_id(),dto.getEmp_name(),dto.getAddress());
    }
    public boolean updateEmployee(final EmployeeDto dto) throws SQLException {
        return SQLUtil.execute("UPDATE employee SET emp_name = ?, address = ? WHERE emp_id = ?",dto.getEmp_name(),dto.getAddress(),dto.getEmp_id());
    }
    public EmployeeDto searchEmployee(String emp_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE emp_id = ?",emp_id);
        resultSet.next();
        return new EmployeeDto(emp_id +"",resultSet.getString("emp_name"),resultSet.getString("address"));
    }

    public List<EmployeeDto> getAllEmployees() throws SQLException {
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

    public boolean deleteEmployee(String emp_id) throws SQLException {
        return SQLUtil.execute("DELETE FROM employee WHERE emp_id = ?" ,emp_id);
    }

    public static List<EmployeeDto> loadAllEmployees() throws SQLException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM employee");
        List<EmployeeDto> empList = new ArrayList<>();

        while (resultSet.next()) {
            empList.add(new EmployeeDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)

            ));
        }
        return empList;
    }

}




