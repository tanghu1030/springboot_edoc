package com.th.service;

import com.github.pagehelper.PageInfo;
import com.th.entity.EdocEntry;
import com.th.entity.EdocEntryCondition;

import java.util.List;

public interface EdocEntryService {

    PageInfo<EdocEntry> findAll(Integer page, Integer limit);

    EdocEntry findById(Long id);

    PageInfo<EdocEntry> findByCondition(EdocEntryCondition edocEntryCondition, Integer page, Integer limit);

    void insert(EdocEntry edocEntry);

    void update(EdocEntry edocEntry);

    void delete(Long id);

    List<EdocEntry> findAllEdocEntry();

    int insertEdocEntry(EdocEntry edocEntry);

    int updateEdocEntry(EdocEntry edocEntry);

    int deleteEdocEntry(Integer id);

}
