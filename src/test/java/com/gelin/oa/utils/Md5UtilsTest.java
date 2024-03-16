package com.gelin.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class Md5UtilsTest {

    @Test
    public void md5Digest() {
        String s = Md5Utils.md5Digest("123456");
        System.out.println(s);
    }


    @Test
    public void testMd5Digest() {
        String s = Md5Utils.md5Digest("123456", 12);
        System.out.println(s);
    }
}