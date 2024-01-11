package lk.ijse.superHardware.bo.Impl;

import lk.ijse.superHardware.bo.custom.SupplierBO;
import lk.ijse.superHardware.dao.DAOFactory;
import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.EmployeeDAO;
import lk.ijse.superHardware.dao.custom.SupplierDAO;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.EmployeeDto;
import lk.ijse.superHardware.dto.ItemStockDto;
import lk.ijse.superHardware.dto.SupplierDto;
import lk.ijse.superHardware.entity.Customer;
import lk.ijse.superHardware.entity.Employee;
import lk.ijse.superHardware.entity.ItemStock;
import lk.ijse.superHardware.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO supplierDAO =
            (SupplierDAO) DAOFactory.getDaoFactory().
                    getDAO(DAOFactory.DAOTypes.SUPPILIER);


    public boolean saveSupplier(SupplierDto dto) throws SQLException{
        //employee business logic example
        return supplierDAO.save(new Supplier(dto.getSup_id(),dto.getSup_name(),dto.getAddress(),dto.getEmail()));
    }


    public boolean updateSupplier(final SupplierDto dto) throws SQLException {
        return supplierDAO.update(new Supplier(dto.getSup_id(),dto.getSup_name(),dto.getAddress(),dto.getEmail()));

    }


    public boolean deleteSupplier(String sup_id) throws SQLException {
        return supplierDAO.delete(sup_id);
    }

    @Override
    public List<SupplierDto> getAllSuppliers() throws SQLException {
        return null;
    }


    public SupplierDto searchSupplier(String sup_id) throws SQLException {
        SupplierDto supplier=supplierDAO.search(sup_id);
        SupplierDto supplierDto=new SupplierDto(supplier.getSup_id(),supplier.getSup_name(),supplier.getAddress(),supplier.getEmail());
        return supplierDto;
    }


    public List<SupplierDto> getAll() throws SQLException {
        List<SupplierDto> suppliers= supplierDAO.getAll();
        List<SupplierDto> supplierDtos=new ArrayList<>();
        for (SupplierDto supplier:suppliers) {
            supplierDtos.add(new SupplierDto(supplier.getSup_id(),supplier.getSup_name(),supplier.getAddress(),supplier.getEmail()));
        }
        return supplierDtos;
    }
}



