package com.example.machinetask;

import java.io.Serializable;

class AssinmentObject  implements Serializable {
    String Name,Age,RollNo;

    public AssinmentObject(String name, String age, String rollNo) {
        Name = name;
        Age = age;
        RollNo = rollNo;
    }

    public AssinmentObject() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }
}
