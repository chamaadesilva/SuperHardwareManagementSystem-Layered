package lk.ijse.superHardware.dao.impl;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.ItemStockDAO;
import lk.ijse.superHardware.dto.ItemStockDto;
import lk.ijse.superHardware.entity.Employee;
import lk.ijse.superHardware.entity.ItemStock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

  public class ItemStockDAOImpl implements ItemStockDAO {
    @Override
    public boolean save(ItemStock entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO item_stock VALUES(?, ?, ?, ?, ?)",
                entity.getItem_stock_code(),entity.getItem_name(),entity.getItem_unit_price(),entity.getQuantity(),entity.getItem_cateogry());
    }


    @Override
      public boolean update(ItemStock entity)throws SQLException {
        return SQLUtil.execute("UPDATE item_stock SET item_name = ?, item_unit_price = ?, quantity = ?, item_cateogry=? WHERE item_stock_code = ?",
                entity.getItem_name(),entity.getItem_unit_price(),entity.getQuantity(),entity.getItem_cateogry(),entity.getItem_stock_code());
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
    public boolean delete(String item_stock_code) throws SQLException {
        return SQLUtil.execute("DELETE FROM item_stock WHERE item_stock_code = ?", item_stock_code);
    }

    @Override
    public List<ItemStockDto> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item_stock");
        List<ItemStockDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String item_Stock_code = resultSet.getString(1);
            String item_name = resultSet.getString(2);
            double item_unit_price = resultSet.getDouble(3);
            int quantity = resultSet.getInt(4);
            String item_cateogry = resultSet.getString(5);

            var dto = new ItemStockDto(item_Stock_code, item_name, item_unit_price, quantity, item_cateogry);
            dtoList.add(dto);
        }
        return dtoList;

    }

    @Override
    public ItemStockDto search(String item_stock_code) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item_stock_code WHERE item_stock_code = ?", item_stock_code);
        resultSet.next();
        return new ItemStockDto(item_stock_code + "", resultSet.getString("item_name"), resultSet.getDouble("item_unit_price"), resultSet.getInt("quantity"), resultSet.getString("item_cateogry"));

    }

//      @Override
//      public boolean save(ItemStock itemStock) {
//          return false;
//      }
//
//      @Override
//      public boolean update(ItemStock itemStock) {
//          return false;
//      }
  }
