package org.collection;

/**
 * Created by LiChaojie on 2016/3/1.
 */
public class EnumTest {
    public static void main(String[] args){
        for(Season season : Season.values()){
            System.out.println(season);
        }

        Season spring = Enum.valueOf(Season.class,"SPRING");
        System.out.println(spring + ":" + spring.getName());
    }
}

enum Season{
    SPRING("����"),SUMMER("����"),FALL("����"),WINTER("����");
    private final String name;
    private Season(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
