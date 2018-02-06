package com.makenv.filter;

import com.makenv.wrapper.CompressionResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class CompressionFilter implements Filter {

    /*
     * 对返回进行压缩的过滤器
     */
    private ServletContext servletContext;
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        servletContext = filterConfig.getServletContext();
        servletContext.log(filterConfig.getFilterName() + "init");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        //获取客户能接受的压缩格式
        String validEncodings = request.getHeader("Accept-Encoding");
        if (validEncodings.indexOf("gzip") > -1) {
            CompressionResponseWrapper wrappedResp = new CompressionResponseWrapper(response);
            wrappedResp.setHeader("Content-Encoding", "gzip");
            //链到下一个组件
            chain.doFilter(request, wrappedResp);

            GZIPOutputStream gzipOutputStream = wrappedResp.getGzipSevletOuputStream();
            gzipOutputStream.finish();
            servletContext.log(filterConfig.getFilterName() + ": finished the request.");
        } else {
            servletContext.log(filterConfig.getFilterName() + ": no encoding performed.");
        }
    }

    public void destroy() {
        //让vm回收
        servletContext = null;
        filterConfig = null;
    }
}
