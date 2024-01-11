package lk.ijse.superHardware.bo;

import lk.ijse.superHardware.bo.Impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)?boFactory=
                new BOFactory():boFactory;

    }
    public enum BOTypes{
        CUSTOMER,EMPLOYEE,ITEMSTOCK,PLACEORDER,SUPPLIER
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case ITEMSTOCK:
                return new ItemStockBOImpl();
            case PLACEORDER:
                return new PlaceOrderBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            default:
                return null;
        }
    }
}


