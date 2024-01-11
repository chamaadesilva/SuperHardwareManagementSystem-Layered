package lk.ijse.superHardware.entity;

public class Customer {

    private String cust_id;
        private String cust_name;
        private String address;

        private int contact;

        public Customer(String cust_id, String cust_name, String address,int contact) {
            this.cust_id = cust_id;
            this.cust_name = cust_name;
            this.address = address;
            this.contact = contact;
        }

        public Customer() {
        }

        public String getCust_id() {
            return cust_id;
        }

        public void setCust_id(String cust_id) {
            this.cust_id = cust_id;
        }

        public String getCust_name() {
            return cust_name;
        }

        public void setCust_name(String cust_name) {
            this.cust_name = cust_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getContact(){
            return contact;
        }

        public void setContact(int contact){
            this.contact  =  contact;
        }

    //public Customer(String custId, String custName, String address, int contact) {
   // }

    }



