package cn.netbuffer.server.test.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Properties;

@RestController
@RequestMapping("/server/info")
public class ServerInfoController {

    @GetMapping
    public Properties serverInfo() {
        return System.getProperties();
    }
}
