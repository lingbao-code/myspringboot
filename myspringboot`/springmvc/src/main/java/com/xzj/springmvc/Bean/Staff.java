package com.xzj.springmvc.Bean;

/*
    JSR-303 Java的标准验证框架
    @NotNull,@Null,@NotBlank,@NotEmpty
 */

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class Staff {
    @Null(message = "职员编号在添加职员的时候必须为空")
    private Integer staffId;

    @NotNull(message = "姓氏不能为空")
    @NotBlank(message = "姓氏不能为空字符串")
    private String firstName;

    @NotNull(message = "名字不能为空")
    @NotBlank(message = "名字不能为空字符串")
    private String lastName;

    @Email(message = "邮箱格式不正确")
    private String email;
    private Addr addr;
    private Store store;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Staff() {
    }

    public Staff(Integer staffId, String firstName, String lastName) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Addr getAddr() {
        return addr;
    }

    public void setAddr(Addr addr) {
        this.addr = addr;
    }
}
