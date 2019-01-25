package mainRun;


import mainRun.bean.SpdUser;
import mainRun.bean.result.ResultBean;
import mainRun.bean.result.ResultFactory;
import mainRun.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/15
 * Time: 15:02
 */
@RestController
@RequestMapping("/regist")
public class RegistController {
    @Resource
    private RegistService registService;

    /**
     * @param userBean
     * @return java.lang.String
     * @author 栗旭辰
     * @date 15:34 2019/1/15
     * @Description: 保存注册表信息
     */
    @PostMapping(value = "/addRegistInfo")
    public ResultBean addRegistInfo( @RequestBody SpdUser userBean) {
        return registService.saveRegistResult(userBean);
    }


    /**
     * @param username
     * @param result
     * @return mainRun.bean.result.ResultBean
     * @author 栗旭辰
     * @date 17:39 2019/1/16
     * @Description: 验证注册信息是否存在
     */
    @GetMapping("/{username}")
    public ResultBean checkRegistInfo(@PathVariable String username) {
        return registService.validRegistInfo(username);
    }

}
