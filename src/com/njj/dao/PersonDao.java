package com.njj.dao;

import com.njj.bean.Person;

import java.util.List;

public interface PersonDao {
    //全查
    List<Person> selectAll();
}
