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
        log.debug("receive task for sleep {} second", sleep);
        TimeUnit.SECONDS.sleep(sleep);
        log.debug("successfully sleep for {} second", sleep);
        return sleep;
    }

}