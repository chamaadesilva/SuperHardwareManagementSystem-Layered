package lk.ijse.superHardware.dao.impl;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.SupplierDAO;
import lk.ijse.superHardware.dto.SupplierDto;
import lk.ijse.superHardware.entity.Employee;
import lk.ijse.superHardware.entity.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public boolean save(final Supplier entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO supplier VALUES(?, ?, ?, ?)",
                entity.getSup_id(),entity.getSup_name(),entity.getAddress(),entity.getEmail());
    }

    @Override
    public boolean update(final Supplier entity) throws SQLException {
        return SQLUtil.execute( "UPDATE supplier SET sup_name = ?, address = ?, suplier_email= ? WHERE sup_id = ?",
                entity.getSup_name(),entity.getAddress(),entity.getEmail(),entity.getSup_id());
    }

    @Override
    public boolean save(Employee dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Employee dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String sup_id) throws SQLException {
        return SQLUtil.execute("DELETE FROM supplier WHERE sup_id = ?",sup_id);
    }

    @Override
    public List<SupplierDto> getAll() throws SQLException {
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

    @Override
    public SupplierDto search(String sup_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM supplier WHERE sup_id = ?",sup_id);
        resultSet.next();
        return new SupplierDto(sup_id +"",resultSet.getString("sup_name"),resultSet.getString("sup_address"),resultSet.getString("sup_email"));

    }



}
