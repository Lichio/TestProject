/**
 * test org.rabbitMQ.scenario.sequence
 *
 * @author lichaojie
 * @version 2019/5/2 15:30
 *
 *
 * * 如何保证RabbitMQ消息的顺序执行 ?
 * 在MQ层面支持消息的顺序执行开销较大，且这种需求较小，所以应在应用层面进行处理
 * 1. 通过全局的消息序列号进行顺序管理
 * 2. 消息体通过hash分派到队列里，每个队列对应一个消费者，多分拆队列。
 * （ 同一组的任务会被分配到同一个队列里，每个队列只能有一个worker来消费，这样避免了同一个队列多个消费者消费时乱序的可能！
 *  比如同一个下单操作中的①创建订单任务和②扣减库存任务属于同一组任务，把这两个任务分配到同一个队列中，且按顺序发布，
 *  因为每个队列只有一个消费者来执行，所以这两个任务的执行顺序是有序的）
 *
 *  OrderSequence:OrderNumber,TaskNumber
 *
 */
package org.rabbitMQ.scenario.sequence;