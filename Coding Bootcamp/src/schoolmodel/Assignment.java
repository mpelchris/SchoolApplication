/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmodel;


import java.time.LocalDate;
import java.time.LocalDateTime;



/**
 *
 * @author christy
 */
public class Assignment {
    private int assignmetid;
    private int courseid;
    private String title;
    private String Description;
    private LocalDateTime submission_date;
    
    //private int oral_mark;
    //private int total_mark;

    public Assignment() {
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

    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public LocalDateTime getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(LocalDateTime submission_date) {
        this.submission_date = submission_date;
    }

   

   
   

    

//    public int getOral_mark() {
//        return oral_mark;
//    }
//
//    public void setOral_mark(int oral_mark) {
//        this.oral_mark = oral_mark;
//    }
//
//    public int getTotal_mark() {
//        return total_mark;
//    }
//
//    public void setTotal_mark(int total_mark) {
//        this.total_mark = total_mark;
//    }

    @Override
    public String toString() {
        return "Assignment{" + "assignmetid=" + assignmetid + ", courseid=" + courseid + ", title=" + title + ", Description=" + Description + ", submission_date=" + submission_date + '}';
    }

    
   

    
    
    
}
