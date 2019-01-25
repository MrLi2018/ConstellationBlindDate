package mainRun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2018/11/27
 * Time: 13:58
 */
@Controller
@RequestMapping("/pages")
public class HelloWorld {
    @RequestMapping(value = "/jumpPage")
    @ResponseBody
    public String jumpPage() {
        return "mmm";
    }
}
