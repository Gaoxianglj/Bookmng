package com.example.accenturespringbootdemo.controller;

import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.example.accenturespringbootdemo.entity.LogRetrieve;
import com.example.accenturespringbootdemo.gongju.CsvExportUtil;
import com.example.accenturespringbootdemo.service.LogRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 登录日志接口处理器。
 */
@RestController
public class LoginLogExportController {

	@Resource
	private LogRetrieveService logRetrieveService;

	@GetMapping(value = "/login/log/export")
	public Object exportCsvs(HttpServletResponse response) {
		 List<LogRetrieve>	list= logRetrieveService.LogRetrieve();
		System.out.println(list.toString());
		if (list.size() == 0) {
			System.out.println("无数据导出");
		}
		String sTitle = "用户名,用户id,用户类型,登录时间";

		String fName = LocalDate.now()+"_log";
		String mapKey = "userName,userId,userType,loginDateTime";
		List<Map<String, Object>> dataList = new ArrayList<>();
		Map<String, Object> map = null;

		for (LogRetrieve order : list) {
			map = new HashMap<>();
			map.put("userName", order.getUserName());
			map.put("userId", order.getUserId());
			map.put("userType", order.getUserType());
			map.put("loginDateTime", order.getLoginDateTime());
			dataList.add(map);
		}
		try (final OutputStream os = response.getOutputStream()) {
			CsvExportUtil.responseSetProperties(fName, response);
			CsvExportUtil.doExport(dataList, sTitle, mapKey, os);
			return null;
		} catch (Exception e) {
			e.getMessage();
		}
		return map;

	}
}