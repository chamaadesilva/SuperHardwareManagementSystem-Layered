package lk.ijse.superHardware.dao.custom;

import lk.ijse.superHardware.dao.CrudDAO;
import lk.ijse.superHardware.dto.ItemStockDto;
import lk.ijse.superHardware.entity.ItemStock;

import java.sql.SQLException;
import java.util.List;

public interface ItemStockDAO extends CrudDAO<ItemStockDto> {
    boolean save(ItemStock itemStock) throws SQLException;

    boolean update(ItemStock itemStock) throws SQLException;
    /*boolean saveItemStock(ItemStockDto itemStockDto) throws SQLException;

    boolean updateItemStock(ItemStockDto itemStockDto) throws SQLException;

    boolean deleteItemStock(String item_stock_code) throws SQLException;

    List<ItemStockDto> getAllItemStocks() throws SQLException;

    ItemStockDto searchItemStock(String item_stock_code) throws SQLException;

     */
}
