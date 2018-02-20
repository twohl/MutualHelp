package com.script.mapper;

import com.script.entity.Share;

import java.util.List;
import java.util.Map;

public interface ShareMapper {

    void addShare(Map map);

    List selectShareByPosition(Map map);

    Share selectShareById(Map map);

}
