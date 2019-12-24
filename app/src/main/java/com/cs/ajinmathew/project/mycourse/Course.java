package com.cs.ajinmathew.project.mycourse;

public class Course {
    String course_Title;
    String course_duration;
    String course_venue;
    String course_date;
    String course_description;

    public Course() {
    }

    public Course(String course_Title, String course_duration, String course_venue, String course_date, String course_description) {
        this.course_Title = course_Title;
        this.course_duration = course_duration;
        this.course_venue = course_venue;
        this.course_date = course_date;
        this.course_description = course_description;
    }

    public String getCourse_Title() {
        return course_Title;
    }

    public void setCourse_Title(String course_Title) {
        this.course_Title = course_Title;
    }

    public String getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(String course_duration) {
        this.course_duration = course_duration;
    }

    public String getCourse_venue() {
        return course_venue;
    }

    public void setCourse_venue(String course_venue) {
        this.course_venue = course_venue;
    }

    public String getCourse_date() {
        return course_date;
    }

    public void setCourse_date(String course_date) {
        this.course_date = course_date;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }
}

