package com.ryan.ms_access.contoller;

import com.ryan.ms_access.domain.Table1;
import com.ryan.ms_access.service.Table1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/access/table")
@RequiredArgsConstructor
public class Table1Controller {

  private final Table1Service table1Service;

  @PostMapping
  public ResponseEntity<?> createTable(@RequestBody Table1 table) {
    table1Service.saveTable(table);
    return ResponseEntity.ok("ok");
  }

  @PostMapping("/return")
  public ResponseEntity<?> createTableAndReturn(@RequestBody Table1 table) {
    Table1 insertedTable = table1Service.saveTableAndReturn(table);
    return ResponseEntity.ok(insertedTable);
  }

  @GetMapping
  public ResponseEntity<?> getAllTable() {
    return ResponseEntity.ok(table1Service.getAllTable());
  }
}
