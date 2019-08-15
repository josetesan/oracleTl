package com.josetesan.oracletl;

import io.micrometer.core.annotation.Counted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Slf4j
public class EventRowMapper implements RowMapper<EventRow> {

    @Override
    @Counted
    public EventRow mapRow(ResultSet resultSet, int i) throws SQLException {
        log.info("Reading row {}",i);
        return EventRow.newBuilder()
            .withId(resultSet.getLong("id"))
            .withCreateDate(resultSet.getTimestamp("create_date"))
            .withPayload(resultSet.getString("payload"))
            .withTipo(resultSet.getString("tipo"))
            .build();
    }
}
