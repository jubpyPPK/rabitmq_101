package com.ppk.rabbitmq_101.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQConfigProperties {

  private String heartBeat;
  private String uri;
  private String virtualHost;
  private String username;
  private String password;
  private String ppkRoutingKey;
  private String ppkExchangeName;
  private String ppkQueueName;

  public String getHeartBeat() {
    return heartBeat;
  }

  public void setHeartBeat(String heartBeat) {
    this.heartBeat = heartBeat;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getVirtualHost() {
    return virtualHost;
  }

  public void setVirtualHost(String virtualHost) {
    this.virtualHost = virtualHost;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPpkRoutingKey() {
    return ppkRoutingKey;
  }

  public void setPpkRoutingKey(String ppkRoutingKey) {
    this.ppkRoutingKey = ppkRoutingKey;
  }

  public String getPpkExchangeName() {
    return ppkExchangeName;
  }

  public void setPpkExchangeName(String ppkExchangeName) {
    this.ppkExchangeName = ppkExchangeName;
  }

  public String getPpkQueueName() {
    return ppkQueueName;
  }

  public void setPpkQueueName(String ppkQueueName) {
    this.ppkQueueName = ppkQueueName;
  }
}
