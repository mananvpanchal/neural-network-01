package org.frozenarc.ai.neuralnetwork;

import org.junit.Assert;
import org.junit.Test;

/*
* Author: Manan
* Date: 20-08-2019 18:44
*/
public class UtilTest {

    @Test
    public void convertToIdx() {

        Assert.assertEquals(19, Util.convertToIdx(20, 0.90));
    }
}
