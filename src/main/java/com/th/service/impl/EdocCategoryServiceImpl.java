package com.th.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.th.entity.EdocCategory;
import com.th.mapper.EdocCategoryMapper;
import com.th.service.EdocCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdocCategoryServiceImpl implements EdocCategoryService {

    @Autowired
    private EdocCategoryMapper edocCategoryMapper;

    @Override
    public List<EdocCategory> findAll() {
        return edocCategoryMapper.findAll();

    }

    @Override
    public EdocCategory findById(Long id) {
        return edocCategoryMapper.findById(id);
    }

    @Override
    public PageInfo<EdocCategory> findByCondition(EdocCategory edocCategory, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<EdocCategory> list = edocCategoryMapper.findByCondition(edocCategory);
        PageInfo<EdocCategory> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }

    @Override
    public void insert(EdocCategory edocCategory) {
        edocCategoryMapper.insert(edocCategory);
    }

    @Override
    public void update(EdocCategory edocCategory) {
        edocCategoryMapper.update(edocCategory);
    }

    @Override
    public void delete(Long id) {
        edocCategoryMapper.delete(id);
    }
}
