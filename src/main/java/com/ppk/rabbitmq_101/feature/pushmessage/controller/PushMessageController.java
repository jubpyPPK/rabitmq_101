package com.ppk.rabbitmq_101.feature.pushmessage.controller;

import com.ppk.rabbitmq_101.common.service.RabbitMQService;
import com.ppk.rabbitmq_101.feature.pushmessage.domain.PpkMessage;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushMessageController {

  private static final Logger logger = Logger.getLogger(PushMessageController.class);

  private RabbitMQService rabbitMQService;

  public PushMessageController(RabbitMQService rabbitMQService) {
    this.rabbitMQService = rabbitMQService;
  }

  @PostMapping("/push_rabbit")
  public String producerMessage(@RequestBody PpkMessage ppkMessage) {
    logger.info("## Start producer message.");
    this.rabbitMQService.sendMessage(ppkMessage);
    return "SUCCESS";
  }


}
