package com.ppk.rabbitmq_101.feature.consumemessage;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumeMessage {

  private static final Logger logger = Logger.getLogger(ConsumeMessage.class);

  @RabbitListener(queues = "${rabbitmq.ppk-queue-name}")
  public void ppkConsumer(String message) {
    logger.info(String.format("consumeMessge is : %s", message));
  }


}
