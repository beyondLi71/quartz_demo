package com.beyondli.enums;

import java.io.Serializable;

public enum JobOperateEnum {
    START(0, "启动"),
    PAUSE(1, "暂停"),
    DELETE(2, "删除");

    private final Integer value;
    private final String desc;

    JobOperateEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Serializable getValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getEnumName() {
        return name();
    }
}
