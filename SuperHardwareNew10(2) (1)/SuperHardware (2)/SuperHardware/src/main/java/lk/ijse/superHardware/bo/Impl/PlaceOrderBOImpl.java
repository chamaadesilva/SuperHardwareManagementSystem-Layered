package lk.ijse.superHardware.bo.Impl;

import lk.ijse.superHardware.bo.custom.PlaceOrderBO;
import lk.ijse.superHardware.dao.DAOFactory;
import lk.ijse.superHardware.dao.QueryDAO;
import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.*;
import lk.ijse.superHardware.db.DbConnection;
import lk.ijse.superHardware.dto.CartDTO;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.OrderDto;
import lk.ijse.superHardware.dto.OrderItemDetailsDto;
import lk.ijse.superHardware.entity.Order;
import lk.ijse.superHardware.entity.OrderItemDetails;
import lk.ijse.superHardware.model.ItemStockModel;
import lk.ijse.superHardware.model.OrderItemDetailsModel;
import lk.ijse.superHardware.model.OrderModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    ItemStockDAO itemStockDAO = (ItemStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEMSTOCK);
    OrderItemDetailsDAO orderDetailsDAO = (OrderItemDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERITEMDETAILS);
    QueryDAO queryDAO= (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);


    // @Override
    // public static boolean placeOrder() throws SQLException {
    // return placeOrder(null, null, null, 0.0, null);
    // }


    public static boolean placeOrder() throws SQLException {
        return placeOrder(null, null, null, 0.0, null);
    }

    public static boolean placeOrder(String ordrId, String customerId, Date date, double netTotal, List<CartDTO> cartDTOList) throws SQLException {
        boolean result = false;
        Connection con = null;

        try {
            con = DbConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            OrderDto orderDto = new OrderDto(ordrId, netTotal, date, customerId);
            boolean isSaved = OrderModel.save(orderDto);
            if (isSaved) {
                boolean isUpdate = ItemStockModel.updateQty(cartDTOList);
                if (isUpdate) {
                    OrderItemDetailsDto detailsDto = new OrderItemDetailsDto(ordrId, cartDTOList);
                    boolean isOrdered = OrderItemDetailsModel.save(detailsDto);
                    if (isOrdered) {
                        con.commit();
                        result = true;
                    }
                }
            }
        } catch (SQLException er) {
            System.out.println("place order= " + er);
            con.rollback();
        } finally {
            con.setAutoCommit(true);
        }
        return result;


    }

    public static boolean save(OrderItemDetailsDto detailsDto) throws SQLException {
        for(CartDTO dto : detailsDto.getCartDTOList()){
            if(!save(detailsDto.getOrder_id(), dto)){
                return false;
            }
        }
        return true;
    }
    public static boolean save(String orderId, CartDTO dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO order_item_details(item_stock_code, order_id, ord_quantity)" +
         "VALUES(?, ?, ?)");
    }



    @Override
    public boolean update(OrderItemDetailsDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<OrderItemDetails> getAll() throws SQLException {
        return null;
    }

    @Override
    public OrderItemDetails search(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderItemDetailsDto> orderDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CustomerDto searchCustomer(String cust_id) throws SQLException, ClassNotFoundException {
        return null;
    }
}