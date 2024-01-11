package lk.ijse.superHardware.model;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.db.DbConnection;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class SupplierModel {
    public boolean saveSupplier(final SupplierDto dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO supplier VALUES(?, ?, ?, ?)",dto.getSup_id(),dto.getSup_name(),dto.getAddress(),dto.getEmail());
    }


    public boolean updateSupplier(final SupplierDto dto) throws SQLException {
        return SQLUtil.execute( "UPDATE supplier SET sup_name = ?, address = ?, suplier_email= ? WHERE sup_id = ?",dto.getSup_name(),dto.getAddress(),dto.getEmail(),dto.getSup_id());
    }


    public SupplierDto searchSupplier(String sup_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM supplier WHERE sup_id = ?",sup_id);
        resultSet.next();
        return new SupplierDto(sup_id +"",resultSet.getString("sup_name"),resultSet.getString("sup_address"),resultSet.getString("sup_email"));

    }



    public List<SupplierDto> getAllSuppliers() throws SQLException {
        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM supplier");
        List<SupplierDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String sup_id = resultSet.getString(1);
            String sup_name = resultSet.getString(2);
            String sup_address = resultSet.getString(3);
            String sup_email = resultSet.getString(4);

            var dto = new SupplierDto(sup_id, sup_name, sup_address, sup_email);
            dtoList.add(dto);
        }
        return dtoList;

    }


    public boolean deleteSupplier(String sup_id) throws SQLException {
        return SQLUtil.execute("DELETE FROM supplier WHERE sup_id = ?",sup_id);
    }


    public List<SupplierDto> loadAllSuppliers() throws SQLException {
        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM supplier");
        List<SupplierDto> supplierList = new ArrayList<>();


        while (resultSet.next()) {
            supplierList.add(new SupplierDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return supplierList;
    }


}





