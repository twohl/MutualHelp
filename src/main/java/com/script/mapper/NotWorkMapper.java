package com.script.mapper;

import com.script.entity.NotWork;

import java.util.List;
import java.util.Map;

public interface NotWorkMapper {

    void addNotWork(Map map);

    void updateNoteWork(Map map);

    List selectNotWorkByPosition(Map map);

    NotWork selectNotWorkById(Map map);
}
