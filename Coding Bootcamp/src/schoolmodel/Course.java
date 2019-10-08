/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmodel;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author christy
 */
public class Course {
    private int id;
    private String title;
    private String stream;  // java or c#
    private LocalDate start_date;
    private LocalDate end_date;

    public Course() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

   

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + ", stream=" + stream + ", start_date=" + start_date + ", end_date=" + end_date + '}';
    }

    
    
    
}
