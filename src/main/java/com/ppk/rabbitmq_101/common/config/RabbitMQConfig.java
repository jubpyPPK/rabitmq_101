package com.ppk.rabbitmq_101.common.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

  private RabbitMQConfigProperties rabbitMQConfigProperties;

  public RabbitMQConfig(
      RabbitMQConfigProperties rabbitMQConfigProperties) {
    this.rabbitMQConfigProperties = rabbitMQConfigProperties;
  }

  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

    connectionFactory
        .setRequestedHeartBeat(Integer.parseInt(this.rabbitMQConfigProperties.getHeartBeat()));
    connectionFactory.setUri(this.rabbitMQConfigProperties.getUri());
    connectionFactory.setVirtualHost(this.rabbitMQConfigProperties.getVirtualHost());
    connectionFactory.setUsername(this.rabbitMQConfigProperties.getUsername());
    connectionFactory.setPassword(this.rabbitMQConfigProperties.getPassword());

    return connectionFactory;
  }

  @Bean
  public MessageConverter simpleMessageConverter() {
    return new SimpleMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate() {
    RabbitTemplate template = new RabbitTemplate(connectionFactory());
    template.setMessageConverter(simpleMessageConverter());
    return template;
  }

}
