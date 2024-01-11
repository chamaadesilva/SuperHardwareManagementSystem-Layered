package lk.ijse.superHardware.bo.custom;

import lk.ijse.superHardware.bo.SuperBO;
import lk.ijse.superHardware.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    boolean save(EmployeeDto dto) throws SQLException;

    boolean update(EmployeeDto dto) throws SQLException;

    boolean delete(String emp_id) throws SQLException;

    List<EmployeeDto> getAll() throws SQLException;

    EmployeeDto search(String emp_id) throws SQLException;
}
