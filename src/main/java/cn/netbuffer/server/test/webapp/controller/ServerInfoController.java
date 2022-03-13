package cn.netbuffer.server.test.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("/server/info")
public class ServerInfoController {

    @GetMapping("properties")
    public Properties properties() {
        return System.getProperties();
    }

    @GetMapping("env")
    public Map<String, String> env() {
        return System.getenv();
    }

}
