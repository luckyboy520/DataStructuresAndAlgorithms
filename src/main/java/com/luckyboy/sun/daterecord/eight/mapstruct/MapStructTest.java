package com.luckyboy.sun.daterecord.eight.mapstruct;

import java.util.Date;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-08-10 10:38
 **/
public class MapStructTest {
    public static void main(String[] args) {
        PersonDO personDO = new PersonDO();
        personDO.setName("luckyboy");
        personDO.setAge(26);
        personDO.setBirthday(new Date());
        personDO.setId(1);
        personDO.setGender(Gender.BOY.getName());

        PersonDTO personDTO = PersonConverter.INSTANCE.do2dto(personDO);
        System.out.println(personDTO);
    }
}
