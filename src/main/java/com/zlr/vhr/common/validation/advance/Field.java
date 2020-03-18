package com.zlr.vhr.common.validation.advance;

public @interface Field {
    public String name();

    public String[] values() default {};
}
