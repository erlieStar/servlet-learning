package com.javashitang.util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClassUtilTest {

    @Test
    public void getAllClassByPackageName() {
        List<Class<?>> classList = ClassUtil.getAllClassByPackageName("com.javashitang.controller");
        System.out.println(classList.size());
    }
}