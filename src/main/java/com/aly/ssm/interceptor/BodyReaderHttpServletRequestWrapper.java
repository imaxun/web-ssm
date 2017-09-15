package com.aly.ssm.interceptor;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 包装HttpServletRequest对象，缓存body数据，再次读取的时候将缓存的值写出
 * Created by yulipeng on 2017/6/19.
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private final String body;

    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);

        //commons.io.jar 方法
        body = IOUtils.toString(request.getInputStream(), "UTF-8");
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                body.getBytes(Charset.forName("UTF-8")));

        ServletInputStream servletInputStream = new ServletInputStream() {
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
        return servletInputStream;
    }
}
