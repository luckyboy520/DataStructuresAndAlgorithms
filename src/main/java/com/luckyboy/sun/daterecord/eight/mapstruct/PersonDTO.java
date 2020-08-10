package com.luckyboy.sun.daterecord.eight.mapstruct;

import java.util.Date;

/**
 * @description: 使用mapstruct是性能很快，而且类型自定义转换，
 * 不要使用apache的超级慢，因为做了很多校验等等
 * 官网： https://mapstruct.org/
 * @author: LuckyBoy
 * @create: 2020-08-10 10:19
 **/
public class PersonDTO {
    private String userName;
    private Integer age;
    private Date birthday;
    private Gender gender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
