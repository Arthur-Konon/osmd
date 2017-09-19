package osmd.entity;

import java.util.Date;

/**
 * Created by arthk on 07.09.2017.
 */
public class CompanyInfo {  //table `companyinfo`
  private int id; //ID` int(11) NOT NULL,PRIMARY KEY AUTO_INCREMENT,
  private boolean active;   //  `Active` tinyint(1) NOT NULL,
  private String name;  // `Name` varchar(50) NOT NULL,
  private String address;  //  `Address` longtext,
  private String  phone;  //  `Phone` varchar(10) DEFAULT NULL,
  private String email; //  `Email` varchar(50) DEFAULT NULL,
  private int managerId;  //  `ManagerID` int(11) NOT NULL,REFERENCES `people` (`ID`)
  private String taxIdNum;  //  `TaxIdNum` varchar(10) DEFAULT NULL,
  private String taxNum;  //  `TaxNum` varchar(50) DEFAULT NULL,
  private String  bankCode; //  `BankCode` varchar(10) DEFAULT NULL,
  private String bankName;  //  `BankName` varchar(50) DEFAULT NULL,
  private String accountNum;  //  `AccountNum` varchar(50) DEFAULT NULL,
  private String remark;  //  `Remark` longtext,
  private java.util.Date  lastUpdate;  // `LastUpdate` date NOT NULL

  public CompanyInfo(int id, boolean active, String name, String address, String phone, String email, int managerId, String taxIdNum, String taxNum, String bankCode, String bankName, String accountNum, String remark, Date lastUpdate) {
    this.id = id;
    this.active = active;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.managerId = managerId;
    this.taxIdNum = taxIdNum;
    this.taxNum = taxNum;
    this.bankCode = bankCode;
    this.bankName = bankName;
    this.accountNum = accountNum;
    this.remark = remark;
    this.lastUpdate = lastUpdate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
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

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }
}
