package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.entity.LoginLog;
import com.example.accenturespringbootdemo.entity.User;
import com.example.accenturespringbootdemo.service.LoginLogService;
import com.example.accenturespringbootdemo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.example.accenturespringbootdemo.controller.LoginLogController;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-03-19 20:12:48
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private LoginLogService loginLogService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }


    /**
     * 登录
     *
     * @param email 邮箱
     * @param password 密码
     * @return 登录是否成功
     * */
    @PostMapping("login")
    public ResponseEntity<Object> Login(@Param("email") String email, @Param("password") String password){
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        Page<User> userPage= this.userService.queryByPage(user,PageRequest.of(0,5));
        List<User> userList=userPage.getContent();
        if(userList.size()==1){
            //查询成功
            User user1=userList.get(0);
            Date date = new Date();

            LoginLog loginLog=new LoginLog();
            loginLog.setUserId(user1.getUserId());loginLog.setUserType(user1.getUserType());loginLog.setDeleteFlag(0);loginLog.setLoginDateTime(date);loginLog.setUpdateDateTime(date);
            try{
            loginLogService.insert(loginLog);
            } catch (Exception e) {
                e.printStackTrace();
                return getEntity("登录日志创建失败",HttpStatus.INTERNAL_SERVER_ERROR);
            }
            //加入登录日志错误判断
            return getEntity(user1,HttpStatus.OK);
        }else {
            //查询失败
            return getEntity("失败",HttpStatus.BAD_REQUEST);
            //错误细分
        }

    }
    @PostMapping("login/er")
    public ResponseEntity<Object> Loginer(@Param("email") String email, @Param("password") String password){
     return getEntity(userService.login(email,password),HttpStatus.OK);
    }
    private static ResponseEntity<Object> getEntity(Object body, HttpStatus statusCode) {
        //一次获取所有Header,如果 Header中有多个参数，可以使用 MultiValueMap来接收参数值。
        //MultiValueMap继承以Map,是一个可以让key拥有多个value的
        MultiValueMap<String, String> headers = new HttpHeaders();
        List<String> contentType = new ArrayList<String>();
        contentType.add("application/json;charset=utf-8");
        headers.put("Content-Type", contentType);
        return new ResponseEntity<Object>(body, headers, statusCode);
    }


}
/*HttpStatus.对应的内容所对应的代码及含义
* HttpStatus = {
        //Informational 1xx  信息
        '100' : 'Continue',  //继续
        '101' : 'Switching Protocols',  //交换协议

        //Successful 2xx  成功
        '200' : 'OK',  //OK
        '201' : 'Created',  //创建
        '202' : 'Accepted',  //已接受
        '203' : 'Non-Authoritative Information',  //非权威信息
        '204' : 'No Content',  //没有内容
        '205' : 'Reset Content',  //重置内容
        '206' : 'Partial Content',  //部分内容

        //Redirection 3xx  重定向
        '300' : 'Multiple Choices',  //多种选择
        '301' : 'Moved Permanently',  //永久移动
        '302' : 'Found',  //找到
        '303' : 'See Other',  //参见其他
        '304' : 'Not Modified',  //未修改
        '305' : 'Use Proxy',  //使用代理
        '306' : 'Unused',  //未使用
        '307' : 'Temporary Redirect',  //暂时重定向

        //Client Error 4xx  客户端错误
        '400' : 'Bad Request',  //错误的请求
        '401' : 'Unauthorized',  //未经授权
        '402' : 'Payment Required',  //付费请求
        '403' : 'Forbidden',  //禁止
        '404' : 'Not Found',  //没有找到
        '405' : 'Method Not Allowed',  //方法不允许
        '406' : 'Not Acceptable',  //不可接受
        '407' : 'Proxy Authentication Required',  //需要代理身份验证
        '408' : 'Request Timeout',  //请求超时
        '409' : 'Conflict',  //指令冲突
        '410' : 'Gone',  //文档永久地离开了指定的位置
        '411' : 'Length Required',  //需要Content-Length头请求
        '412' : 'Precondition Failed',  //前提条件失败
        '413' : 'Request Entity Too Large',  //请求实体太大
        '414' : 'Request-URI Too Long',  //请求URI太长
        '415' : 'Unsupported Media Type',  //不支持的媒体类型
        '416' : 'Requested Range Not Satisfiable',  //请求的范围不可满足
        '417' : 'Expectation Failed',  //期望失败

        //Server Error 5xx  服务器错误
        '500' : 'Internal Server Error',  //内部服务器错误
        '501' : 'Not Implemented',  //未实现
        '502' : 'Bad Gateway',  //错误的网关
        '503' : 'Service Unavailable',  //服务不可用
        '504' : 'Gateway Timeout',  //网关超时
        '505' : 'HTTP Version Not Supported'  //HTTP版本不支持
};  */
