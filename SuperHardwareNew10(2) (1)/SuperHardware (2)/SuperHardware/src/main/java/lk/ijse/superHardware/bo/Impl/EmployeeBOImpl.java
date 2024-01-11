package lk.ijse.superHardware.bo.Impl;

import lk.ijse.superHardware.bo.custom.EmployeeBO;
import lk.ijse.superHardware.dao.DAOFactory;
import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.EmployeeDAO;
import lk.ijse.superHardware.dto.EmployeeDto;
import lk.ijse.superHardware.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO =
            (EmployeeDAO) DAOFactory.getDaoFactory().
                    getDAO(DAOFactory.DAOTypes.EMPOLYEE);


     public boolean save(EmployeeDto dto) throws SQLException{
         //employee business logic example
         return employeeDAO.save(new Employee(dto.getEmp_id(),dto.getEmp_name(),dto.getAddress()));
     }


     public boolean update(final EmployeeDto dto) throws SQLException {
         return employeeDAO.update(new Employee(dto.getEmp_id(),dto.getEmp_name(),dto.getAddress()));

     }

     @Override
     public boolean delete(String emp_id) throws SQLException {
         return employeeDAO.delete(emp_id);
     }


     public EmployeeDto search(String emp_id) throws SQLException {
         EmployeeDto employee=employeeDAO.search(emp_id);
         EmployeeDto employeeDto=new EmployeeDto(employee.getEmp_id(),employee.getEmp_name(),employee.getAddress());
         return employeeDto;
     }


     public List<EmployeeDto> getAll() throws SQLException {
         List<EmployeeDto> employees= employeeDAO.getAll();
         List<EmployeeDto> employeeDtos=new ArrayList<>();
         for (EmployeeDto employee:employees) {
             employeeDtos.add(new EmployeeDto(employee.getEmp_id(),employee.getEmp_name(),employee.getAddress()));
         }
         return employeeDtos;
     }


     //public boolean deleteEmployee(String emp_id) throws SQLException {
     //return employeeDAO.delete(emp_id);
    // }

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




