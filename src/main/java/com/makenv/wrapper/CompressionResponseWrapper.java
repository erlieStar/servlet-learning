package com.makenv.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

public class CompressionResponseWrapper extends HttpServletResponseWrapper {

    private GZIPSevletOuputStream gzipSevletOuputStream = null;

    private PrintWriter pw = null;

    private Object streamUsed = null;

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response
     * @throws IllegalArgumentException if the response is null
     */
    public CompressionResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public GZIPOutputStream getGzipSevletOuputStream() {
        return this.gzipSevletOuputStream.gzipOutputStream;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if ((streamUsed != null) && (streamUsed != pw)) {
            throw new IllegalStateException();
        }
        if (gzipSevletOuputStream == null) {
            gzipSevletOuputStream = new GZIPSevletOuputStream(getResponse().getOutputStream());
            streamUsed = gzipSevletOuputStream;
        }
        return gzipSevletOuputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {

        if ((streamUsed != null) && (streamUsed != gzipSevletOuputStream)) {
            throw new IllegalStateException();
        }
        if (pw == null) {
            gzipSevletOuputStream = new GZIPSevletOuputStream(getResponse().getOutputStream());
            OutputStreamWriter osw = new OutputStreamWriter(gzipSevletOuputStream, getResponse().getCharacterEncoding());
            pw = new PrintWriter(osw);
            streamUsed = pw;
        }
        return pw;
    }
}
