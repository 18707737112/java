package com.iotek.util;

import com.iotek.util.CodeUtil;

import org.junit.Test;

import java.util.Arrays;


//测试生成验证码
public class CodeUtilTest {
    private CodeUtil codeUtil = new CodeUtil();
    @Test
    public void code(){
        char[] arr = codeUtil.getCode();
        System.out.println(Arrays.toString(arr));
        //验证结果[2, q, E, Z]
    }
}
