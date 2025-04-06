package com.th.mapper;

import com.th.entity.EdocCategory;
import java.util.List;

public interface EdocCategoryMapper {

    List<EdocCategory> findAll();

    EdocCategory findById(Long id);

    List<EdocCategory> findByCondition(EdocCategory edocCategory);

    void insert(EdocCategory edocCategory);

    void update(EdocCategory edocCategory);

    void delete(Long id);
}
