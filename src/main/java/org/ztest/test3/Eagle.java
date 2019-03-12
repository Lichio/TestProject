package org.ztest.test3;

/**
 * Created by Lichaojie on 2017/2/7.
 */
public class Eagle extends Bird {

    Eagle(){}
    Eagle(String species){setSpecies(species);}

    @Override
    public void run(){System.out.println(species + "run!");}

    @Override
    public void fly(){System.out.println(species + "fly!");}
}
