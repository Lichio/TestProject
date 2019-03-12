package org.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lichaojie on 2017/2/13.
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{}

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }
    }
}
