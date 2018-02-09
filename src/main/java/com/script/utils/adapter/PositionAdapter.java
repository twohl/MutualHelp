package com.script.utils.adapter;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class PositionAdapter {

    private final static Logger logger = Logger.getLogger(PositionAdapter.class);


    public static Map getPositionRangMap(Map map){

        logger.debug("Adapter调用:***将位置点信息映射为范围位置信息***");

        double dis = 500.00/111000.00;

        Map newMap = new HashMap();

        Double lng = Double.parseDouble((String) map.get("lng"));

        Double lat = Double.parseDouble((String) map.get("lat"));

        double lng_min = lng - dis;
        double lng_max = lng + dis;
        double lat_min = lat - dis;
        double lat_max = lat + dis;

        newMap.put("lng_min",lng_min);
        newMap.put("lng_max",lng_max);
        newMap.put("lat_min",lat_min);
        newMap.put("lat_max",lat_max);

        logger.debug("Adapter调用:***映射成功***");

        return newMap;

    }
}
