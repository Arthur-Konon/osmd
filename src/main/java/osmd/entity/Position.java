package osmd.entity;
import java.util.Date;

/**
 * Created by arthk on 08.09.2017.
 */
public class Position {    //    table `positions`

    private int id;             //       `ID` int(11) NOT NULL AUTO_INCREMENT,PRIMARY KEY
    private String name;        //  `Position` varchar(50) NOT NULL,
    private boolean ispaid;     //  `IsPaid` tinyint(1) DEFAULT NULL,
    private boolean isStated;   //  `IsStated` tinyint(1) DEFAULT NULL,
    private String Remark;      //  `Remark` longtext,
    private java.util.Date lastUpdate;   //     `LastUpdate` date NOT NULL,

    public Position(int id, String name, boolean ispaid, boolean isStated, String remark, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.ispaid = ispaid;
        this.isStated = isStated;
        Remark = remark;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIspaid() {
        return ispaid;
    }

    public void setIspaid(boolean ispaid) {
        this.ispaid = ispaid;
    }

    public boolean isStated() {
        return isStated;
    }

    public void setStated(boolean stated) {
        isStated = stated;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
