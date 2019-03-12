package org.annotation;

/**
 * Created by LiChaojie on 2016/3/10.
 */

public class JDBCIndexTest {
    public static void main(String[] args){
        System.out.println("This program do nothing without recording something!");
    }
}

//对employees表上的last_name列创建索引，创建索引后将能提高对last_name列的查询速度。
//create index emp_last_name_index2
//on employees(last_name);