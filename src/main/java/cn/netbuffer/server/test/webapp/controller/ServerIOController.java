package cn.netbuffer.server.test.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/server/io")
public class ServerIOController {

    @GetMapping("write")
    public boolean write(String path, String message) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(message.getBytes());
        fileOutputStream.close();
        return true;
    }

    @GetMapping("read")
    public String read(String path) throws IOException {
        byte[] message = new byte[1024];
        FileInputStream fileInputStream = new FileInputStream(path);
        fileInputStream.read(message);
        fileInputStream.close();
        return new String(message);
    }

}
