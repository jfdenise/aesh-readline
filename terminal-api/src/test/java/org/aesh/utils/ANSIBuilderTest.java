package org.aesh.utils;

import org.aesh.utils.ANSIBuilder.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:stalep@gmail.com">Ståle Pedersen</a>
 */
public class ANSIBuilderTest {

    private static final String COLOR_START = "\u001B[";
    private static final String RESET = "\u001B[0m";

    @Test
    public void testAnsiBuilder() {
        ANSIBuilder builder = new ANSIBuilder();

        assertEquals(COLOR_START+"0;"+ Color.YELLOW.text()+";"+Color.DEFAULT.bg()+"m"+"FOO"+RESET,
                builder.yellowText().append("FOO").toString());

        builder.clear();
        assertEquals(COLOR_START+"0;"+ Color.YELLOW.text()+";"+Color.DEFAULT.bg()+"m"+"FOO"+RESET,
                builder.yellowText("FOO").toString());

        builder.clear();
        assertEquals("FOO"+COLOR_START+"0;"+ Color.DEFAULT.text()+";"+Color.BLUE.bg()+"m"+" BAR"+RESET,
                builder.append("FOO").resetColors().blueBg().append(" BAR").toString());

        builder.clear();
        assertEquals("FOO"+COLOR_START+"0;"+ Color.DEFAULT.text()+";"+Color.BLUE.bg()+"m"+" BAR"+RESET,
                builder.append("FOO").resetColors().blueBg(" BAR").toString());

        builder.clear();

    }
}