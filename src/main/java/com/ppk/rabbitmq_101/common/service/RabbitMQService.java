package com.ppk.rabbitmq_101.common.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppk.rabbitmq_101.common.config.RabbitMQConfigProperties;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

  private static final Logger logger = Logger.getLogger(RabbitMQService.class);

  private RabbitMQConfigProperties rabbitMQConfigProperties;
  private RabbitTemplate rabbitTemplate;

  public RabbitMQService(
      RabbitMQConfigProperties rabbitMQConfigProperties,
      RabbitTemplate rabbitTemplate) {
    this.rabbitMQConfigProperties = rabbitMQConfigProperties;
    this.rabbitTemplate = rabbitTemplate;
  }

  @Async
  public void sendMessage(Object object) {

    try {
      ObjectMapper objectMapper = new ObjectMapper();
      String message = objectMapper.writeValueAsString(object);

      logger.info(String.format("sendMessage to %s:%s, messsage is : %s",
          rabbitTemplate.getConnectionFactory().getHost(),
          rabbitTemplate.getConnectionFactory().getPort(), message));

      this.rabbitTemplate.convertAndSend(this.rabbitMQConfigProperties.getPpkExchangeName(),
          this.rabbitMQConfigProperties.getPpkRoutingKey(), message);
    } catch (Exception e) {
      logger.error("Exception :: {} ", e);
    }
  }

  @Async
  public void receiveMessage(String message) {
    logger.info(String.format("receiveMessage from %s:%s, messsage is : %s",
        rabbitTemplate.getConnectionFactory().getHost(),
        rabbitTemplate.getConnectionFactory().getPort(), message));
    this.rabbitTemplate.receive(this.rabbitMQConfigProperties.getPpkQueueName());
  }
}


