package com.josetesan.oracletl;

import io.micrometer.core.annotation.Counted;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EventRowMapper implements RowMapper<EventRow> {

  private static final Logger LOGGER = LoggerFactory.getLogger(EventRowMapper.class);

  @Override
  @Counted
  public EventRow mapRow(ResultSet resultSet, int i) throws SQLException {
    LOGGER.info("Reading row {}", i);
    return new EventRow(
        resultSet.getLong("id"),
        resultSet.getTimestamp("create_date"),
        resultSet.getString("payload"),
        resultSet.getString("tipo"));
  }
}
