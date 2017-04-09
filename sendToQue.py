#!/usr/bin/env python
import pika


def sendErrorToQue(errorCode):
    connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
    channel = connection.channel()

    channel.queue_declare(queue='errors')

    channel.basic_publish(exchange='',
                          routing_key='errors',
                          body=errorCode)

    connection.close()
