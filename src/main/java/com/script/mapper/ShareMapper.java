package com.script.mapper;

import com.script.entity.Share;

public interface ShareMapper {

    void addShare(Share share);

    void delShareById(int id);

    Share[] selectAllShare();

    Share[] selectShareByUser(int user_id);

}
