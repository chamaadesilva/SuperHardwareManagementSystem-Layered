package lk.ijse.superHardware.bo.Impl;

import lk.ijse.superHardware.bo.custom.ItemStockBO;
import lk.ijse.superHardware.dao.DAOFactory;
import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.CustomerDAO;
import lk.ijse.superHardware.dao.custom.ItemStockDAO;
import lk.ijse.superHardware.db.DbConnection;
import lk.ijse.superHardware.dto.CartDTO;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.EmployeeDto;
import lk.ijse.superHardware.dto.ItemStockDto;
import lk.ijse.superHardware.entity.Customer;
import lk.ijse.superHardware.entity.Employee;
import lk.ijse.superHardware.entity.ItemStock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 public class ItemStockBOImpl implements ItemStockBO {

    ItemStockDAO itemStockDAO =
            (ItemStockDAO) DAOFactory.getDaoFactory().
                    getDAO(DAOFactory.DAOTypes.ITEMSTOCK);

    public static List<String> loadItemCodes() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT item_stock_code FROM item_stock";
        PreparedStatement pstm = connection.prepareStatement(sql);
        List<String> allItemCodes = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            allItemCodes.add(resultSet.getString(1));
        }
        return allItemCodes;
    }

    public static ItemStockDto searchByItemCode(String item_stock_code) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item_stock WHERE item_stock_code = ?",item_stock_code);
        resultSet.next();

        return new ItemStockDto(item_stock_code +"",resultSet.getString("item_name"),resultSet.getDouble("item_unit_price"),resultSet.getInt("quantity"),resultSet.getString("item_cateogry"));

    }

    public static boolean updateQty(List<CartDTO> cartDTOList) throws SQLException {
        for(CartDTO dto : cartDTOList){
            if(!updateQty(dto)){
                return false;
            }
        }
        return true;
    }
    private static boolean updateQty(CartDTO dto) throws SQLException {
        return SQLUtil.execute( "UPDATE item_stock SET quantity = (quantity - ?) WHERE item_stock_code = ?",dto.getItemQty(),dto.getItemCode());
    }

    ///////////////////////new ///////////////////////////////////////////////////////////////////////////

    public boolean saveItemStock(ItemStockDto dto) throws SQLException {
        return itemStockDAO.save(new ItemStock(dto.getItem_stock_code(),dto.getItem_name(),dto.getItem_unit_price(),dto.getQuantity(),dto.getItem_cateogry()));
    }

    public ItemStockDto searchItemStock(String item_stock_code) throws SQLException {
        ItemStockDto itemStock = itemStockDAO.search(item_stock_code);
        ItemStockDto itemStockDto = new ItemStockDto(itemStock.getItem_stock_code(),itemStock.getItem_name(),itemStock.getItem_unit_price(),itemStock.getQuantity(),itemStock.getItem_cateogry());
        return itemStockDto;
    }

    public boolean deleteItemStock(String item_stock_code) throws SQLException {
        return itemStockDAO.delete(item_stock_code);
    }


    public List<ItemStockDto> loadAllItemStocks() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item_stock");
        List<ItemStockDto> dtoList = new ArrayList<>();


        while (resultSet.next()) {
            var dto = new ItemStockDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            );

            dtoList.add(dto);
        }

        return dtoList;
    }


    public boolean updateItemStock(ItemStockDto dto) throws SQLException {
        return itemStockDAO.update(new ItemStock(dto.getItem_stock_code(),dto.getItem_name(),dto.getItem_unit_price(),dto.getQuantity(),dto.getItem_cateogry()));

    }

    public List<ItemStockDto>getAllItemStocks() throws SQLException{

        List<ItemStockDto> itemStocks= itemStockDAO.getAll();
        List<ItemStockDto> itemStockDtos=new ArrayList<>();
        for (ItemStockDto itemStock:itemStocks) {
            itemStockDtos.add(new ItemStockDto(itemStock.getItem_stock_code(),itemStock.getItem_name(),itemStock.getItem_unit_price(),itemStock.getQuantity(),itemStock.getItem_cateogry()));
        }
        return itemStockDtos;
    }
}
