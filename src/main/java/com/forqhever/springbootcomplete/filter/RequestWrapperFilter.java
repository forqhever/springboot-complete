package com.forqhever.springbootcomplete.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@Component
@WebFilter(filterName = "RequestWrapperFilter")
public class RequestWrapperFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(RequestWrapperFilter.class);

    public void destroy() {
        // NOOP
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        logger.info("进入过滤器！");

        CustomRequestWrapper requestWrapper = new CustomRequestWrapper((HttpServletRequest) req);

        logger.info("过滤器中获得：{}", requestWrapper.getRequestBody());

        chain.doFilter(requestWrapper, resp);

        requestWrapper.closeInputStream();
    }

    public void init(FilterConfig config) throws ServletException {
        // NOOP
    }

    private class CustomRequestWrapper extends HttpServletRequestWrapper {

        private ServletInputStream servletInputStream;
        byte[] bytes;
        private String requestBody;

        CustomRequestWrapper(HttpServletRequest request) throws IOException {
            super(request);
            ServletInputStream inputStream = request.getInputStream();

            bytes = inputStream.readAllBytes();
            requestBody = new String(bytes);
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {

            servletInputStream = new ServletInputStream() {

                int i = 0;

                @Override
                public boolean isFinished() {
                    return i == bytes.length;
                }

                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setReadListener(ReadListener listener) {
                    // NOOP
                }

                @Override
                public int read() throws IOException {
                    return i == bytes.length ? -1 : bytes[i++];
                }
            };

            return servletInputStream;
        }

        String getRequestBody() {
            return requestBody;
        }


        void closeInputStream() throws IOException {
            servletInputStream.close();
        }
    }

}
