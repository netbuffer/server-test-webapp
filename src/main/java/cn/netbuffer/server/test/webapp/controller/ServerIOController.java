package cn.netbuffer.server.test.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/server/io")
public class ServerIOController {

    @GetMapping("write")
    public boolean write(String path, String message) throws IOException {
        log.debug("server write test path[{}] message[{}]", path, message);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(message.getBytes());
        fileOutputStream.close();
        return true;
    }

    @GetMapping("read")
    public String read(String path) throws IOException {
        log.debug("server read test path[{}]", path);
        byte[] message = new byte[1024];
        FileInputStream fileInputStream = new FileInputStream(path);
        fileInputStream.read(message);
        fileInputStream.close();
        return new String(message);
    }

    @GetMapping("diskspace")
    public void diskspace(@RequestParam(required = false, defaultValue = ".") String path) {
        File file = new File(path);
        long usableSpace = file.getUsableSpace();
        long totalSpace = file.getTotalSpace();
        long freeSpace = file.getFreeSpace();
        log.debug("path[{}] usableSpace={} totalSpace={} freeSpace={}", file.getAbsolutePath(), usableSpace, totalSpace, freeSpace);
        System.out.println("path=" + file.getAbsolutePath() + " usableSpace=" + usableSpace + " totalSpace=" + totalSpace + " freeSpace=" + freeSpace);
    }

}
