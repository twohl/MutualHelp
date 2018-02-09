package com.script.mapper;

import com.script.entity.Note;

public interface NoteMapper {

    void addNote(Note note);

    void delNoteByUser(int user_id);

    Note[] selectNoteByUser(int user_id);

    Note[] selectNoteByTarget(int target_id);
}
