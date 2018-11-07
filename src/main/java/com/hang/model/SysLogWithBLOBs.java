package com.hang.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysLogWithBLOBs extends SysLog {

	private String oldValue;

    private String newValue;
}