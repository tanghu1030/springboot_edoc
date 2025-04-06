package com.th.mapper;

import com.th.entity.EdocEntry;
import com.th.entity.EdocEntryCondition;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EdocEntryMapper {

    List<EdocEntry> findAll();

    EdocEntry findById(Long id);

    List<EdocEntry> findByCondition(EdocEntryCondition edocEntryCondition);

    void insert(EdocEntry edocEntry);

    void update(EdocEntry edocEntry);

    void delete(Long id);

    @Select("select * from edoc_entry")
    List<EdocEntry> findAllEdocEntry();

    @Insert("insert into edoc_entry(categoryId, title, summary, uploaduser, createdate) values(#{categoryId}, #{title}, #{summary}, #{uploaduser}, #{createdate})")
    int insertEdocEntry(EdocEntry edocEntry);

    @Update("update edoc_entry set categoryId = #{categoryId}, title = #{title}, summary = #{summary}, uploaduser = #{uploaduser}, createdate = #{createdate} where id = #{id}")
    int updateEdocEntry(EdocEntry edocEntry);

    @Delete("delete from edoc_entry where id = #{id}")
    int deleteEdocEntry(@Param("id") Integer id);

}
