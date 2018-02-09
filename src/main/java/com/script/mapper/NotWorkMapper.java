package com.script.mapper;

import com.script.entity.NotWork;

public interface NotWorkMapper {

    void addNotWork(NotWork notWork);

    void updateNoteWork(NotWork notWork);

    NotWork[] selectAllNotWork();

    NotWork selectNotWorkByid(int id);
}
