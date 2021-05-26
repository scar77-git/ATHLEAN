package com.example.testapp;


public class user {

    // string variable for
    // storing employee name.
    private String Name;

    // string variable for storing
    // employee contact number
    private String ContactNumber;

    // string variable for storing
    // employee address.
    private String flag;
    private Integer count;
    private Integer sets;
    private Integer time;
    private String review;
    private Integer st;
    private Integer times;
    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public user() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getEmployeeName() {
        return Name;
    }

    public void setEmployeeName(String employeeName) {
        this.Name = employeeName;
    }

    public String getEmployeeContactNumber() {
        return ContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.ContactNumber = employeeContactNumber;
    }

    public String getflag() {
        return flag;
    }

    public void setflag(String flag1) {
        this.flag = flag1;
    }

    public Integer getsets() {
        return sets;
    }

    public void setSets(Integer sets1) {
        this.sets = sets1;
    }
    public Integer gettime() {
        return time;
    }

    public void settime(Integer times1) {
        this.time = times1;
    }
    public String getReview() {
        return review;
    }

    public void setReview(String reviews1) {
        this.review = reviews1;
    }
    public void setst(Integer st1){this.st=st1;}
    public Integer getst(){return st;}
    public void settimes(Integer t1){this.times=t1;}
    public Integer gettimes(){return times;}

}
