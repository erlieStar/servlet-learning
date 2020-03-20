package com.javashitang.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZIPSevletOuputStream extends ServletOutputStream {

    //这个实例变量在包范围内私有，所以响应包装器可以访问这个变量
    GZIPOutputStream gzipOutputStream;

    public GZIPSevletOuputStream(ServletOutputStream servletOutputStream) throws IOException {
        this.gzipOutputStream = new GZIPOutputStream(servletOutputStream);
    }

    public boolean isReady() {
        return false;
    }

    public void setWriteListener(WriteListener writeListener) {

    }

    public void write(int b) throws IOException {
        gzipOutputStream.write(b);
    }
}
