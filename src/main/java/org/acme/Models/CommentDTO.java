package org.acme.Models;

public class CommentDTO {
    int UID;
    int SID;
    String comments;

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "CommentTDO{" +
                "UserID=" + UID +
                ", SeriesID=" + SID +
                ", comments='" + comments + '\'' +
                '}';
    }
}
