package mainRun.bean.result;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/9
 * Time: 16:19
 */
public enum ResultCodeBean implements Serializable {
    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 失败
     */
    FAIL(400),

    /**
     * 未认证（签名错误）
     */
    UNAUTHORIZED(401),

    /**
     * 接口不存在
     */
    NOT_FOUND(404),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500);

    public  int code;

    ResultCodeBean(int code) {
        this.code = code;
    }
}
