package com.example.prajwalkulkarni.hostelapplication;

/**
 * Created by Prajwal kulkarni on 4/3/2018.
 */

public class UserPersonal {
    private String Name,FatherName,Usn,Block,Branch,Email;
    private long Mobile,FatherMobile;
    private int Room,Year;

    public void setName(String name) {
        Name = name;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public void setUsn(String usn) {
        Usn = usn;
    }

    public void setBlock(String block) {
        Block = block;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setMobile(long mobile) {
        Mobile = mobile;
    }

    public void setFatherMobile(long fatherMobile) {
        FatherMobile = fatherMobile;
    }

    public void setRoom(int room) {
        Room = room;
    }

    public void setYear(int year) {
        Year = year;
    }

    public UserPersonal(){

    }
    public UserPersonal(String n,String fn,String u,String e,String bl,String br,long mo,long fmo,int r,int y){
        Name=n;
        FatherName=fn;
        Usn=u;
        Email=e;
        Block=bl;
        Branch=br;
        Mobile=mo;
        FatherMobile=fmo;
        Room=r;
        Year=y;
    }

    public String getName() {
        return Name;
    }

    public String getFatherName() {
        return FatherName;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsn() {
        return Usn;
    }

    public String getBlock() {
        return Block;
    }

    public String getBranch() {
        return Branch;
    }

    public long getMobile() {
        return Mobile;
    }

    public long getFatherMobile() {
        return FatherMobile;
    }

    public int getRoom() {
        return Room;
    }

    public int getYear() {
        return Year;
    }
}
