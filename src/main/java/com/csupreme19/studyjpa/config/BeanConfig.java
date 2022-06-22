package com.csupreme19.studyjpa.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 등록을 위한 Configuration 클래스
 * @author csupreme19
 * @since 2022.06.22
 */
@Configuration
public class BeanConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
