package lk.ijse.superHardware.bo.Impl;

import lk.ijse.superHardware.bo.custom.CustomerBO;
import lk.ijse.superHardware.dao.DAOFactory;
import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.CustomerDAO;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
     CustomerDAO customerDAO =
             (CustomerDAO) DAOFactory.getDaoFactory().
                     getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public static CustomerDto searchByCustId(String cust_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer WHERE cust_id = ?",cust_id);
        resultSet.next();

        return new CustomerDto(cust_id +"",resultSet.getString("cust_name"),resultSet.getString("address"),resultSet.getInt("contact"));

    }

    //////////////////////////new ////////////////////////////////////////////////////////////////////////////

     public boolean saveCustomer(CustomerDto dto) throws SQLException{
         //customer business logic example
         return customerDAO.save(new Customer(dto.getCust_id(),dto.getCust_name(),dto.getAddress(),dto.getContact()));
     }



    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        return customerDAO.update(new Customer(dto.getCust_id(),dto.getCust_name(),dto.getAddress(),dto.getContact()));

    }


    public CustomerDto searchCustomer(String cust_id) throws SQLException {
        CustomerDto customer=customerDAO.search(cust_id);
        CustomerDto customerDto=new CustomerDto(customer.getCust_id(),customer.getCust_name(),customer.getAddress(),customer.getContact());
        return customerDto;
    }



  public List<CustomerDto>getAllCustomers() throws SQLException{

        List<CustomerDto> customers= customerDAO.getAll();
         List<CustomerDto> customerDtos=new ArrayList<>();
         for (CustomerDto customer:customers) {
             customerDtos.add(new CustomerDto(customer.getCust_id(),customer.getCust_name(),customer.getAddress(),customer.getContact()));
         }
         return customerDtos;
  }



    public boolean deleteCustomer(String cust_id) throws SQLException {
        return customerDAO.delete(cust_id);
    }




   /* public List<CustomerDto> loadAllCustomers() throws SQLException {
        ResultSet resultSet =SQLUtil.execute( "SELECT * FROM customer");
        List<CustomerDto> custList = new ArrayList<>();

        while (resultSet.next()) {
            custList.add(new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
            ));
        }
        return custList;
    }


    */
}
