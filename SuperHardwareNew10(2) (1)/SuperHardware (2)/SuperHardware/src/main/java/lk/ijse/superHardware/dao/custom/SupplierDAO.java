package lk.ijse.superHardware.dao.custom;

import lk.ijse.superHardware.dao.CrudDAO;
import lk.ijse.superHardware.dto.SupplierDto;
import lk.ijse.superHardware.entity.ItemStock;
import lk.ijse.superHardware.entity.Supplier;

import java.sql.SQLException;

public interface SupplierDAO extends CrudDAO<SupplierDto> {

    static void save(ItemStock itemStock){

    }


    boolean save(Supplier supplier) throws SQLException;

    boolean update(Supplier supplier) throws SQLException;
    /*boolean saveSupplier(SupplierDto dto) throws SQLException;

    boolean updateSupplier(SupplierDto dto) throws SQLException;

    boolean deleteSupplier(String sup_id) throws SQLException;

    List<SupplierDto> getAllSuppliers() throws SQLException;

    SupplierDto searchSupplier(String sup_id) throws SQLException;

     */
}
