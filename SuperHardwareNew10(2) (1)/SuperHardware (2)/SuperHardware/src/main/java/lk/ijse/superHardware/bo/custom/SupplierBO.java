package lk.ijse.superHardware.bo.custom;

import lk.ijse.superHardware.bo.SuperBO;
import lk.ijse.superHardware.dto.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBO extends SuperBO {
    boolean saveSupplier(SupplierDto dto) throws SQLException;

    boolean updateSupplier(SupplierDto dto) throws SQLException;

    boolean deleteSupplier(String sup_id) throws SQLException, SQLException;

    List<SupplierDto> getAllSuppliers() throws SQLException;

    SupplierDto searchSupplier(String sup_id) throws SQLException;


}
