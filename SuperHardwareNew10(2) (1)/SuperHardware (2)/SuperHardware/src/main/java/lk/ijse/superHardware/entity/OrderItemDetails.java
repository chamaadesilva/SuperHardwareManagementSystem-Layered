package lk.ijse.superHardware.entity;

import lk.ijse.superHardware.dto.CartDTO;
import lombok.*;

import java.util.List;



public class OrderItemDetails {

    private String ord_id;
    private String item_stock_code;

    private int ord_quantity;



    public OrderItemDetails(String ord_id,String item_stock_code,int ord_quantity){
        this.item_stock_code = item_stock_code;
        this.ord_id = ord_id;
        this.ord_quantity = ord_quantity;
    }

    public OrderItemDetails(){

    }

    public String getItem_stock_code() {
        return item_stock_code;
    }

    public void setItem_stock_code(String item_stock_code){

        this.item_stock_code =item_stock_code;
    }

    public String getOrd_id(){
        return ord_id;
    }

    public void setOrd_id(String ord_id){
        this.ord_id = ord_id;

    }

    public double getOrd_quantity() {

        return ord_quantity;
    }

    public void setOrd_quantity(int ord_quantity){
        this.ord_quantity = ord_quantity;
    }



}
