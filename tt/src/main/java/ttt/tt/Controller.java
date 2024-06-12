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

}
