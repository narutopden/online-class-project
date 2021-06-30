package com.onlineclass.tibet_online_class.mapper;

import com.onlineclass.tibet_online_class.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Param;

public interface PlayRecordMapper {
    int saveRecord( PlayRecord playRecord);
}
