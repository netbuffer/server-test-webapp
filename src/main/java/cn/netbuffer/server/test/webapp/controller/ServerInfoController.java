package cn.netbuffer.server.test.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
