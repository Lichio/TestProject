/**
 * TestProject org.rabbitMQ.scenario.asynchronous
 *
 * @author Lichaojie
 * @version 2019/4/28 17:25
 *
 * 异步处理
 *
 * 场景说明：用户注册后需要发送注册邮件和注册短信。
 *
 *
 * 同步
 *  --------        ------------------       -----------       ----------
 * |        | ---> |                  |     |           |     |          |
 * |  user  |      | insert user info | --> | send mail | --> | send SMS |
 * |        | <--- |                  |     |           |     |          |
 *  --------        ------------------       -----------       ----------
 *
 * 异步
 *                                                             -----------
 *                                                            |           |
 *                                                            | send mail |
 *  --------        ------------------       -----------      |           |
 * |        | ---> |                  |     |           | <--  -----------
 * |  user  |      | insert user info | --> |     MQ    |
 * |        | <--- |                  |     |           | <--  -----------
 *  --------        ------------------       -----------      |           |
 *                                                            | send SMS  |
 *                                                            |           |
 *                                                             -----------
 */
package org.rabbitMQ.scenario.asynchronous;