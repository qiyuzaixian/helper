package com.github.hps.util;


public interface IdGenerator {
    Long generateId();

    Long generateId(String name);

    Long generateId(Class<?> clz);
}
