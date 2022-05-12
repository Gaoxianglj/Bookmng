package com.example.accenturespringbootdemo.controller;

import com.example.accenturespringbootdemo.entity.LogRetrieve;
import com.example.accenturespringbootdemo.entity.UserEntity;
import com.example.accenturespringbootdemo.service.LogRetrieveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
@SpringBootTest
public class LogRetrieveControllerTest {
    private static final Logger log = LoggerFactory.getLogger(LoginControllerTest.class);
    private MockMvc mvc;
    // 使用mockito提供的@Mock注解装饰外部业务层，模拟外部业务层依赖
    @Mock
    private LogRetrieveService logRetrieveService;
    // 创建一个实例，其余用@Mock注解创建的mock将被注入到用该实例中。
    @InjectMocks
    private LogRetrieveController logRetrieveController;

    // 在被@Test注解装饰的测试方法之前执行被@BeforeEach装饰的非静态方法，@BeforeEach为Junit5提供的注解
    @BeforeEach
    public void setUp() {
        // 执行以后，service自动注入到controller中。
        MockitoAnnotations.openMocks(this);
        // 构建mvc环境
        mvc = MockMvcBuilders.standaloneSetup(logRetrieveController).build();
    }

    /**
     * 测试方法
     * <p>
     * 用于测试LoginController中的Login方法。
     * </p>
     * <p>
     * 注意，测试方法必须为public void 方法， 即公开且无返回值方法。
     * </p>
     * <p>
     * 由于该示例仅展示Junit使用，所以方法直接throw异常。<br>
     * 实际开发过程中应使用try-catch捕获异常并加以处理。
     * </p>
     *
     * @throws Exception
     */
    @Test
    public void testLogin() throws Exception {
        List<LogRetrieve> logRetrieves=new ArrayList<>();
        LogRetrieve logRetrieve=new LogRetrieve();logRetrieve.setUserName("admin");logRetrieve.setUserId(1);logRetrieve.setLoginDateTime(LocalDateTime.of(2022,1,11,14,27,53));
        logRetrieves.add(logRetrieve);

        // 模拟外部业务层依赖返回结果
        when(logRetrieveService.LogRetrieve()).thenReturn(logRetrieves);

        // 构建请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/login/retrieve")
                .contentType(MediaType.APPLICATION_JSON).content("");

        // 发送请求，获取请求结果
        ResultActions perform = mvc.perform(request);

        // 请求结果校验
        perform.andExpect(MockMvcResultMatchers.status().isOk());
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        log.info("response:" + response.getContentAsString());
        // 断言
        assertEquals(getUserEntityFormJson(response.getContentAsString()).get(0).getUserId(), logRetrieves.get(0).getUserId());
        assertEquals(getUserEntityFormJson(response.getContentAsString()).get(0).getUserName(), logRetrieves.get(0).getUserName());
        assertEquals(getUserEntityFormJson(response.getContentAsString()).get(0).getUserType(), logRetrieves.get(0).getUserType());
        assertEquals(getUserEntityFormJson(response.getContentAsString()).get(0).getLoginDateTime(), logRetrieves.get(0).getLoginDateTime());

    }

//    @Test
//    public void testLoginException() throws Exception {
//        List<LogRetrieve> logRetrieves=new ArrayList<>();
//        LogRetrieve logRetrieve=new LogRetrieve();logRetrieve.setUserName("admin");logRetrieve.setUserId(1);logRetrieve.setLoginDateTime(LocalDateTime.of(2022,1,11,14,27,53));
//        logRetrieves.add(logRetrieve);
//        // 模拟外部业务层依赖返回结果
//        when(logRetrieveService.LogRetrieve()).thenReturn(logRetrieves);
//
//        // 构建请求
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/login/retrieve")
//                .contentType(MediaType.APPLICATION_JSON).content("{\"userName\": \"admin\", \"password\": \" \"}");
//
//        Throwable exception = assertThrows(NestedServletException.class, () -> {
//            mvc.perform(request);
//        });
//        assertEquals(
//                exception.getMessage(),"Request processing failed; nested exception is com.example.accenturespringbootdemo.exception.BusinessFailureException"
//        );
//    }

    /**
     * 将字符串型Json数据转为用户实体类。
     * <p>
     * 由于该示例仅为配合展示Junit使用，所以方法直接throw异常。<br>
     * 实际开发过程中应使用try-catch捕获异常并加以处理。
     * </p>
     *
     * @param json 字符串型Json数据
     * @return 用户实体类
     * @throws JsonMappingException
     * @throws JsonProcessingException
     */
    private List<LogRetrieve> getUserEntityFormJson(String json) throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(json, new TypeReference<List<LogRetrieve>>() {
        });
    }

}
