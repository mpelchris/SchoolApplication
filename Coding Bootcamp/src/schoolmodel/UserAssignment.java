/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmodel;

/**
 *
 * @author christy
 */
public class UserAssignment {
    
    private int userid;
    private int assignmetid;
    private int courseid;
    private int oral_mark;
    private int total_mark;

    public UserAssignment() {
    }
    
    

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getAssignmetid() {
        return assignmetid;
    }

    public void setAssignmetid(int assignmetid) {
        this.assignmetid = assignmetid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getOral_mark() {
        return oral_mark;
    }

    public void setOral_mark(int oral_mark) {
        this.oral_mark = oral_mark;
    }

    public int getTotal_mark() {
        return total_mark;
    }

    public void setTotal_mark(int total_mark) {
        this.total_mark = total_mark;
    }

    @Override
    public String toString() {
        return "UserAssignment{" + "userid=" + userid + ", assignmetid=" + assignmetid + ", courseid=" + courseid + ", oral_mark=" + oral_mark + ", total_mark=" + total_mark + '}';
    }
    
    
    
}
