package org.acme.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "streaming.detaillogininfo")
public class DetailLogInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    int id;
    Date logindate;
    String description;

    @OneToMany(mappedBy = "detailLogInfo")
    private List<LogInfo> logInfos = new ArrayList<>();

    public void setLogInfos(List<LogInfo> logInfos) {
        this.logInfos = logInfos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
