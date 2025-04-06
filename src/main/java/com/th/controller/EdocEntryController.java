package com.th.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.th.entity.EdocEntry;
import com.th.entity.EdocEntryCondition;
import com.th.service.EdocEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("edocEntry")
public class EdocEntryController {

    @Autowired
    private EdocEntryService edocEntryService;

    private Logger  logger = LoggerFactory.getLogger(EdocEntryController.class);

    @RequestMapping("/findAll")
    public PageInfo<EdocEntry> findAll(@RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
                                       @RequestParam(name = "limit",required = false,defaultValue = "3") Integer limit){
        return edocEntryService.findAll(page,limit);

    }

    @RequestMapping("/findById/{id}")
    public EdocEntry findById(@PathVariable("id") Long id){
        return edocEntryService.findById(id);

    }


    @RequestMapping("/findByCondition")
    public PageInfo<EdocEntry> findByCondition(@RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
                                               @RequestParam(name = "limit",required = false,defaultValue = "3") Integer limit,
                                                EdocEntryCondition edocEntryCondition, HttpServletRequest request){
        edocEntryCondition = JSON.parseObject(request.getParameter("edocEntryCondition"),EdocEntryCondition.class);
        System.out.println(edocEntryCondition);

        return edocEntryService.findByCondition(edocEntryCondition,page,limit );

    }

    @RequestMapping("/insert")
    public EdocEntry insert(EdocEntry edocEntry, HttpServletRequest request){
        edocEntry = JSON.parseObject(request.getParameter("edocEntry"),EdocEntry.class);
        edocEntryService.insert(edocEntry);
       return edocEntry;

    }

    @RequestMapping("/update")
    public String update(EdocEntry edocEntry, HttpServletRequest request){
        edocEntry = JSON.parseObject(request.getParameter("edocEntry"),EdocEntry.class);
        System.out.println(edocEntry.getCreatedate());
        edocEntryService.update(edocEntry);
        return "修改成功";

    }

    @RequestMapping("/delete/{id}/{page}")
    public Map delete(@PathVariable("id") Long id,
                         @PathVariable("page") Integer page){
        edocEntryService.delete(id);

        Map map = new HashMap();
        map.put("msg","删除成功");
        map.put("page",page);

       return map;

    }

    @RequestMapping("findAllEdocEntry")
    public ResponseEntity<List<EdocEntry>> findAllEdocEntry() {
        return ResponseEntity.ok(edocEntryService.findAllEdocEntry());
    }

    @RequestMapping("insertEdocEntry")
    public ResponseEntity<String> insertEdocEntry(@RequestBody EdocEntry edocEntry) {
        int i = edocEntryService.insertEdocEntry(edocEntry);
        if (i > 0) {
            return ResponseEntity.ok("增加成功");
        } else {
            return ResponseEntity.ok("增加失败");
        }

    }

    @RequestMapping("updateEdocEntry")
    public ResponseEntity<String> updateEdocEntry(@RequestBody EdocEntry edocEntry) {
        int i = edocEntryService.updateEdocEntry(edocEntry);
        if (i > 0) {
            return ResponseEntity.ok("修改成功");
        } else {
            return ResponseEntity.ok("修改失败");
        }
    }

    @RequestMapping("deleteEdocEntry")
    public ResponseEntity<String> deleteEdocEntry(Integer id) {
        int i = edocEntryService.deleteEdocEntry(id);
        if (i > 0) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.ok("删除失败");
        }
    }


}
