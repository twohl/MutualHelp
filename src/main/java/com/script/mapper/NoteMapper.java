package com.script.mapper;

import com.script.entity.Note;

import java.util.Map;

public interface NoteMapper {

    void addNote(Map map);

    void delNoteByUser(int user_id);

    Note[] selectNoteByUser(int user_id);

    Note[] selectNoteByTarget(int target_id);
}
