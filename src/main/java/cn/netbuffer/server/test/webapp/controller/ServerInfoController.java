package cn.netbuffer.server.test.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
@RestController
@RequestMapping("/server/info")
public class ServerInfoController {

    @GetMapping("properties")
    public Properties properties() {
        log.debug("get server properties");
        return System.getProperties();
    }

    @GetMapping("env")
    public Map<String, String> env() {
        log.debug("get server env");
        return System.getenv();
    }

    @GetMapping(value = "request/dump")
    public Map requestDump(HttpServletRequest request) throws IOException {
        log.debug("===================================before request dump===============================");
        Map values = new HashMap();
        log.debug(request.getMethod() + " " + request.getRequestURL());
        Enumeration names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String value = request.getHeader(name);
            log.debug(name + ":" + value);
            values.put(name, value);
        }
        values.put("ServerName", request.getServerName());
        values.put("ServerPort", String.valueOf(request.getServerPort()));
        values.put("Scheme", request.getScheme());
        values.put("Protocol", request.getProtocol());
        values.put("PathInfo", request.getPathInfo());
        values.put("PathTranslated", request.getPathTranslated());
        values.put("ServletPath", request.getServletPath());
        values.put("ContextPath", request.getContextPath());
        values.put("RequestURI", request.getRequestURI());
        values.put("AuthType", request.getAuthType());
        values.put("ContentType", request.getContentType());
        values.put("ContentLength", String.valueOf(request.getContentLength()));
        values.put("QueryString", request.getQueryString());
        values.put("RemoteUser", request.getRemoteUser());
        values.put("RequestedSessionId", request.getRequestedSessionId());
        values.put("Method", request.getMethod());
        values.put("LocalAddr", request.getLocalAddr());
        URL url = new URL("http://checkip.amazonaws.com/");
        URLConnection urlConnection = url.openConnection();// 此处的urlConnection对象实际上是根据URL的
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] message = new byte[inputStream.available()];
        inputStream.read(message);
        inputStream.close();
        values.put("PublicIp", new String(message));
        values.put("LocalName", request.getLocalName());
        values.put("LocalPort", String.valueOf(request.getLocalPort()));
        values.put("RemoteUser", request.getRemoteUser());
        values.put("RemoteAddr", request.getRemoteAddr());
        values.put("RemoteHost", request.getRemoteHost());
        values.put("RemotePort", String.valueOf(request.getRemotePort()));
        log.debug("===================================end request dump===============================");
        return values;
    }

}