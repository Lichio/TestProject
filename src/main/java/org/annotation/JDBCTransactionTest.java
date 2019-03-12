package org.annotation;

/**
 * Created by LiChaojie on 2016/3/10.
 */
public class JDBCTransactionTest {
    public static void main(String[] args){
        System.out.println("This program do nothing without recording something!");
    }
}

//JDBC的事务支持由Connection提供，Connection默认打开自动提交，即关闭事务；这样，每一条SQL一执行，就会提交到数据库，永久生效，不能回滚。
//调用Connection的setAutoCommit()方法，将自动提交关闭，这样就打开了事务，
//这样之后的SQL语句虽然执行了，但并不保存到数据库，只有调用Connection的commit()方法提交才能保存到数据库，且提交前能够回滚。
