package com.itcast;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueneProdecer {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("tcp://192.168.75.102:61616");
        Connection connection=connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("test-quene");
        MessageProducer producer = session.createProducer(queue);
        TextMessage textMessage = session.createTextMessage("欢迎来到品优购");
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();

    }
}
