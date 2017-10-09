package com.arthsoft.osmd.entity;

/**
 * Created by arthk on 07.09.2017.
 */
public class CompanyInfo extends Entity {  //table `companyinfo`

    private String name;  // `Name` varchar(50) NOT NULL,
    private String address;  //  `Address` longtext,
    private String phone;  //  `Phone` varchar(10) DEFAULT NULL,
    private String email; //  `Email` varchar(50) DEFAULT NULL,
    private int managerId;  //  `ManagerID` int(11) NOT NULL,REFERENCES `people` (`ID`)
    private String taxIdNum;  //  `TaxIdNum` varchar(10) DEFAULT NULL,
    private String taxNum;  //  `TaxNum` varchar(50) DEFAULT NULL,
    private String bankCode; //  `BankCode` varchar(10) DEFAULT NULL,
    private String bankName;  //  `BankName` varchar(50) DEFAULT NULL,
    private String accountNum;  //  `AccountNum` varchar(50) DEFAULT NULL,


    @Override
    public String toString() {
        return "CompanyInfo{" +
                "id=" + getId() +
                ", active=" + isActive() +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", managerId=" + managerId +
                ", taxIdNum='" + taxIdNum + '\'' +
                ", taxNum='" + taxNum + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", remark='" + getRemark() + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getTaxIdNum() {
        return taxIdNum;
    }

    public void setTaxIdNum(String taxIdNum) {
        this.taxIdNum = taxIdNum;
    }

    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }


}
