package com.foneom.codeflow.algorythms;

import org.junit.Test;

import static org.junit.Assert.*;

public class UglyTest {
    @Test
    public void sampleTest() {
        assertEquals("AaA", Ugly.uglifyWord("AAA"));
        assertEquals("AaA", Ugly.uglifyWord("AaA"));
        assertEquals("BbB", Ugly.uglifyWord("BbB"));
        assertEquals("AaA-BbB-CcC", Ugly.uglifyWord("aaa-bbb-ccc"));
        assertEquals("AaA-BbB-CcC", Ugly.uglifyWord("AaA-BbB-CcC"));
        assertEquals("EeEe-FfFf-GgGg", Ugly.uglifyWord("eeee-ffff-gggg"));
        assertEquals("EeEe-FfFf-GgGg", Ugly.uglifyWord("EeEe-FfFf-GgGg"));
        assertEquals("QwE123AsDf456ZxC", Ugly.uglifyWord("qwe123asdf456zxc"));
        assertEquals("HeLlO WoRlD", Ugly.uglifyWord("Hello World"));
    }

}