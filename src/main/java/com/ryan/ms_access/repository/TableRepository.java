package com.ryan.ms_access.repository;

import com.ryan.ms_access.domain.Table1;

import java.util.List;

public interface TableRepository {
    void save(Table1 table);
    Table1 saveAndReturn(Table1 table1);
    List<Table1> findAll();
}
