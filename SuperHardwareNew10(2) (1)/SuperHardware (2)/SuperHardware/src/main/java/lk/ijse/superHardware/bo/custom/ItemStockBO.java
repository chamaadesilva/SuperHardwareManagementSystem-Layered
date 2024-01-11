package lk.ijse.superHardware.bo.custom;

import lk.ijse.superHardware.bo.SuperBO;
import lk.ijse.superHardware.dto.ItemStockDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemStockBO extends SuperBO {
    boolean saveItemStock(ItemStockDto itemStockDto) throws SQLException;

    boolean updateItemStock(ItemStockDto itemStockDto) throws SQLException;

    boolean deleteItemStock(String item_stock_code) throws SQLException;

    List<ItemStockDto> getAllItemStocks() throws SQLException;

    ItemStockDto searchItemStock(String item_stock_code) throws SQLException;
}
