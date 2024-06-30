/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tungnk.order;

import java.sql.Date;

/**
 *
 * @author ktung
 */
public class OrderDTO {
    private int order_id;
    private int account_id;
    private Date order_date;
    private String address;
    private String phone;

    public OrderDTO() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public OrderDTO(int order_id, int account_id, Date order_date, String address, String phone) {
        this.order_id = order_id;
        this.account_id = account_id;
        this.order_date = order_date;
        this.address = address;
        this.phone = phone;
    }

    
    public OrderDTO(int account_id, Date order_date, String address, String phone) {
        this.account_id = account_id;
        this.order_date = order_date;
        this.address = address;
        this.phone = phone;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
}
