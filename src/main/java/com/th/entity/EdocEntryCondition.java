package com.th.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
public class EdocEntryCondition {
    private static final long serialVersionUID = 42L;

    private Long id;
    private Long categoryId;
    private String title;
    private String summary;
    private String uploaduser;
    private Date createdate;
    private Date enddate;


}
