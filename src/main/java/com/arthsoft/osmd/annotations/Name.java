package com.arthsoft.osmd.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Names.class)
public @interface Name {
    String name();
    Language language();
}
