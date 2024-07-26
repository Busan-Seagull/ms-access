package com.ryan.ms_access.service;

import com.ryan.ms_access.domain.Table1;
import com.ryan.ms_access.repository.TableRepositoryImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Table1Service {

  private final TableRepositoryImpl tableRepository;

  public void saveTable(Table1 table) {
    tableRepository.save(table);
  }

  public Table1 saveTableAndReturn(Table1 table) {
    return tableRepository.saveAndReturn(table);
  }

  public List<Table1> getAllTable() {
    return tableRepository.findAll();
  }
}
