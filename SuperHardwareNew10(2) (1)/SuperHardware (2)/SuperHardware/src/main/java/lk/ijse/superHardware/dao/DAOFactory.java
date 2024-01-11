package lk.ijse.superHardware.dao;

import lk.ijse.superHardware.dao.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
        private DAOFactory(){
        }
        public static DAOFactory getDaoFactory(){
            return (daoFactory==null)?daoFactory =new DAOFactory():daoFactory;
        }

        public enum DAOTypes{
            CUSTOMER,EMPOLYEE,ITEMSTOCK,ORDER,ORDERITEMDETAILS,SUPPILIER,QUERY
        }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case EMPOLYEE:
                return new EmployeeDAOImpl();
            case ITEMSTOCK:
                return new ItemStockDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERITEMDETAILS:
               return new OrderItemDetailsDAOImpl();
                case SUPPILIER:
                return new SupplierDAOImpl();
                case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }

}



