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
    SPRING("春天"),SUMMER("夏天"),FALL("秋天"),WINTER("冬天");
    private final String name;
    private Season(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
