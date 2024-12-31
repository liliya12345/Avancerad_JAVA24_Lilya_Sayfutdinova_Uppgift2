package org.example.model;

public class Assessment {
    private int id;
    private Subject subject;
    private  Mark mark;
    private int studentId;

    public Assessment(int id, Subject subject, Mark mark) {
        this.id = id;
        this.subject = subject;
        this.mark = mark;
    }

    public Assessment(Subject subject, Mark mark, int studentId) {
        this.subject = subject;
        this.mark = mark;
        this.studentId = studentId;
    }

    public Assessment(int id, Subject subject, Mark mark, int studentId) {
        this.id = id;
        this.subject = subject;
        this.mark = mark;
        this.studentId = studentId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + id +
                ", subject=" + subject +
                ", mark=" + mark +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
