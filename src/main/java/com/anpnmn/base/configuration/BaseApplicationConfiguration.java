package com.anpnmn.base.configuration;

import com.anpnmn.base.controller.BaseController;
import com.anpnmn.base.repository.MessageRepository;
import com.anpnmn.base.repository.impl.MessageRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Configuration
public class BaseApplicationConfiguration {

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Controller
    class BaseControllerBean extends BaseController {
        public BaseControllerBean(final MessageRepository messageRepository) {
            super(messageRepository);
        }
    }

    @Repository
    class MessageRepositoryBean extends MessageRepositoryImpl {
        public MessageRepositoryBean(final NamedParameterJdbcTemplate jdbcTemplate) {
            super(jdbcTemplate);
        }
    }
}
