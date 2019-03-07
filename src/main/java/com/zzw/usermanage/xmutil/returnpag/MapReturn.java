package com.zzw.usermanage.xmutil.returnpag;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/7
 */
public class MapReturn implements Return {
    private Map<Object,Object> map;

    public MapReturn(){
        map=new HashMap<>();
    }

    public void add(Object key,Object value){
        map.put(key,value);
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }


    @Override
    public String toString() {
        return "MapReturn{" +
                "map=" + map +
                '}';
    }
}
