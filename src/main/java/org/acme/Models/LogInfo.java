package org.acme.Models;

import javax.persistence.*;

@Entity
@Table(name = "streaming.logininfo")
public class LogInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "userID")
    User logUser;

    @ManyToOne
    @JoinColumn(name="detailID")
    DetailLogInfo detailLogInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getLogUser() {
        return logUser;
    }

    public void setLogUser(User logUser) {
        this.logUser = logUser;
    }

    public DetailLogInfo getDetailLogInfo() {
        return detailLogInfo;
    }

    public void setDetailLogInfo(DetailLogInfo detailLogInfo) {
        this.detailLogInfo = detailLogInfo;
    }
}
