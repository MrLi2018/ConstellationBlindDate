package mainRun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2018/11/27
 * Time: 13:32
 */

@SpringBootApplication
@MapperScan(basePackages = {"mainRun.dao"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
