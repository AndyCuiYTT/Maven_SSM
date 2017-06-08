package com.andy.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.andy.pojo.User;
import com.andy.service.IUserService;

@Controller
@RequestMapping(value = "/userApi", method = RequestMethod.POST)
public class UserAPIController {

	@Resource
	private IUserService userService;

	@ResponseBody
	@RequestMapping(params = "method=getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@ResponseBody
	@RequestMapping(value = "/uploadfile")
	public Map<String, String> uploadFile(@RequestParam("file") MultipartFile[] tmpFile, HttpServletRequest request) {

		Map<String, String> map = new HashMap<>();
		if (tmpFile.length > 0) {
			// 获取物理路径
			String targetDirectory = request.getSession().getServletContext().getRealPath("/uploads");
			for (int i = 0; i < tmpFile.length; i++) {
				MultipartFile file = tmpFile[i];
				String tmpFileName = file.getOriginalFilename(); // 上传的文件名
				int dot = tmpFileName.lastIndexOf('.');
				String ext = ""; // 文件后缀名
				if ((dot > -1) && (dot < (tmpFileName.length() - 1))) {
					ext = tmpFileName.substring(dot + 1);
				}
				String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date()); // 当前时间字符串
				int random = new Random().nextInt(10000);
				// 重命名上传的文件名
				String targetFileName = formatDate + random + "." + ext;
				// 保存的新文件
				File target = new File(targetDirectory, targetFileName);
				try {
					// 保存文件
					FileUtils.copyInputStreamToFile(file.getInputStream(), target);
					map.put("url" + i, "/uploads/" + targetFileName);
				} catch (IOException e) {
					e.printStackTrace();
					map.put("error", e.getMessage());
				}
			}
		}

		String id = request.getParameter("id");
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setImgurl(map.get("url0"));
		userService.updateUser(user);
		map.put("id", id);
		return map;

	}

}
