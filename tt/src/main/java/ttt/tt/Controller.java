package ttt.tt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String test(HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemotePort());
//        sudo hping3 -S -c 10 -p 80 222.113.106.89
        try {
            Process process = Runtime.getRuntime().exec("ping " + request.getRemoteAddr());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            int count = 0;
            while( count < 10 && (line = reader.readLine()) != null) {
                count++;
                System.out.println(line);
            }
        }
        catch (Exception e) {
            System.out.println("error");
        }
        return "h";
    }

    @GetMapping("/t")
    public String test2(HttpServletRequest request) {
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemotePort());
//        sudo hping3 -S -c 5 -p 80 222.113.106.89
        try {
            Process process = Runtime.getRuntime().exec("sudo hping3 -S -c 5 -p " + request.getRemotePort() + " " + request.getRemoteAddr());
            System.out.println("command = " + "sudo hping3 -S -c 5 -p " + request.getRemotePort() + " " + request.getRemoteAddr());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            int count = 0;
            while( count < 10 && (line = reader.readLine()) != null) {
                count++;
                System.out.println(line);
            }
        }
        catch (Exception e) {
            System.out.println("error");
        }
        return "h";
    }

    @GetMapping("/tt")
    public String test3(HttpServletRequest request) {
        System.out.println("remoteAddr = " + request.getRemoteAddr());
        System.out.println("LocalAddr = " + request.getLocalAddr());
        System.out.println("LocalPort = " + request.getLocalPort());
        System.out.println("remotePort = " + request.getRemotePort());

// /home/ubuntu/tcpping 220.83.158.250 80
        try {
            Process process = Runtime.getRuntime().exec("/home/ubuntu/tcpping " + request.getRemoteAddr() + " " + request.getLocalPort());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            int count = 0;
            while( count < 10 && (line = reader.readLine()) != null) {
                count++;
                System.out.println(line);
            }
        }
        catch (Exception e) {
            System.out.println("error");
        }
        return "h";
    }

}
