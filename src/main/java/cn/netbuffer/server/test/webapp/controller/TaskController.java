package cn.netbuffer.server.test.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @GetMapping("sleep")
    public Long sleep(Long sleep) throws InterruptedException {
        TimeUnit.SECONDS.sleep(sleep);
        log.debug("sleep for {} second", sleep);
        return sleep;
    }

}