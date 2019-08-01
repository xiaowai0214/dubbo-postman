/*
 * MIT License
 *
 * Copyright (c) 2019 everythingbest
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.dubbo.postman.service.maven;

import com.dubbo.postman.util.LogResultPrintStream;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class MavenProcessorTest {

    @Test
    public void testProcess(){

        String key = "user.home";

        System.setProperty(key,"c:\\tmp");

        String nexusUrl = "http://192.168.1.177:8081/nexus/service/local/artifact/maven/redirect";

        String fileBasePath ="c:/tmp";

        MavenProcessor processResources = new MavenProcessor(nexusUrl,fileBasePath);

        String g = "com.dubbo.postman";

        String a = "dubbo-postman-api";

        String v = "1.1.3-SNAPSHOT";

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        LogResultPrintStream resultPrintStream = new LogResultPrintStream(stream);

        processResources.process("test-service",g,a,v,resultPrintStream);

        String mvnOutPut = new String(resultPrintStream.getLogByteArray());

        Assert.assertFalse(mvnOutPut.isEmpty());
    }
}
