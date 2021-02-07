package com.xm6leefun.ocpayprogram.bean;

import java.io.Serializable;

/**
 * @Description: 地址本
 * @Author: ljj
 * @CreateDate: 2021/2/7 16:15
 */
public class AddressBean implements Serializable {

    private String name;
    private String address;

    public AddressBean(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
