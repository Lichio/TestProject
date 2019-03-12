package org.ztest.test3;

/**
 * Created by Lichaojie on 2017/2/7.
 */
public abstract class Bird implements Fly{

    protected String species;

    protected abstract void run();

    protected void sing(){System.out.println(species + "sing!");}

    protected void setSpecies(String species){species = this.species;}
}
