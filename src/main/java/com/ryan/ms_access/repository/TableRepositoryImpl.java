package com.ryan.ms_access.repository;

import com.ryan.ms_access.domain.Table1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TableRepositoryImpl implements TableRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public void save(Table1 table) {
    String sql = "insert into table1 (id, ntest, ttest1, ttest2) values (?, ?, ?, ?)";
    jdbcTemplate.update(sql, table.getId(), table.getNtest(), table.getTtest1(), table.getTtest2());
  }

  @Override
  public Table1 saveAndReturn(Table1 table) {
    String sql = "insert into table1 (id, test, ttest1, ttest2) values (?, ?, ?, ?)";
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(
        new PreparedStatementCreator() {
          @Override
          public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(0, table.getId());
            ps.setInt(1, table.getNtest());
            ps.setString(2, table.getTtest1());
            ps.setString(3, table.getTtest2());
            return ps;
          }
        });
    table.setId(keyHolder.getKey().longValue());
    return table;
  }

  @Override
  public List<Table1> findAll() {
    String sql = "select * from table1";
    return jdbcTemplate.query(sql, new Table1RowMapper());
  }

  private class Table1RowMapper implements RowMapper<Table1> {
    @Override
    public Table1 mapRow(ResultSet rs, int rowNum) throws SQLException {
      Table1 table = new Table1();
      table.setId(rs.getLong("id"));
      table.setNtest(rs.getInt("ntest"));
      table.setTtest1(rs.getString("ttest1"));
      table.setTtest2(rs.getString("ttest2"));
      return table;
    }
  }
}
