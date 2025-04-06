package com.th.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class EdocCategory implements Serializable {

    private static final long serialVersionUID = 42L;

    private Long id;
    private String name;

}
