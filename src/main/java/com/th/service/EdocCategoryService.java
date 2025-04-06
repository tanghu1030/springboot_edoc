package com.th.service;


import com.github.pagehelper.PageInfo;
import com.th.entity.EdocCategory;

import java.util.List;

public interface EdocCategoryService {

    List<EdocCategory> findAll();

    EdocCategory findById(Long id);

    PageInfo<EdocCategory> findByCondition(EdocCategory edocCategory,Integer page, Integer limit);

    void insert(EdocCategory edocCategory);

    void update(EdocCategory edocCategory);

    void delete(Long id);



}
