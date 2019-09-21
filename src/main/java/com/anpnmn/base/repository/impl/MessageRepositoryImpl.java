package com.anpnmn.base.repository.impl;

import com.anpnmn.base.model.Message;
import com.anpnmn.base.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class MessageRepositoryImpl implements MessageRepository {

    private final Logger logger = LoggerFactory.getLogger(MessageRepositoryImpl.class);

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MessageRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Message findMessage() {
        try {
            final SqlParameterSource param = new MapSqlParameterSource();
            return jdbcTemplate.queryForObject(
                    "SELECT text from message;"
                    , param
                    , Message.class
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (DataAccessException e) {
            logger.error("DataAccessError!!!");
            return null;
        }
    }
}
