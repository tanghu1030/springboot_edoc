package com.th.controller;

import com.github.pagehelper.PageInfo;
import com.th.entity.EdocCategory;
import com.th.service.EdocCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("edocCategory")
public class EdocCategoryController {

    @Autowired
    private EdocCategoryService edocCategoryService;

    @Transactional
    @RequestMapping("/findAll")
    public List<EdocCategory> findAll(){
        return edocCategoryService.findAll();

    }

    @RequestMapping("/findById/{id}")
    public EdocCategory findById(@PathVariable("id") Long id){
        return edocCategoryService.findById(id);

    }

    @RequestMapping("/findByCondition")
    public  PageInfo<EdocCategory> findByCondition(@RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
                                               @RequestParam(name = "limit",required = false,defaultValue = "3") Integer limit,
                                               EdocCategory edocCategory){
        return edocCategoryService.findByCondition(edocCategory, page,limit );

    }


    @RequestMapping("/insert")
    public String insert(EdocCategory edocCategory){
       edocCategoryService.insert(edocCategory);
       return "增加成功";

    }

    @RequestMapping("/update")
    public String update(EdocCategory edocCategory){
        edocCategoryService.update(edocCategory);
        return "修改成功";

    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
       edocCategoryService.delete(id);
       return "删除成功";

    }





}
