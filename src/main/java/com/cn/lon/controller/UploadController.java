package com.cn.lon.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cn.lon.entity.AddandCut;
import com.cn.lon.service.IAddAndCutService;
import com.cn.qpm.framework.util.ExceptionUtil;

/**
 * declaration： 
 *		上传文件controller
 */
@Controller
@RequestMapping(value="/uploadController")
public class UploadController {
	
	@Resource(name="addAndCutService")
	private IAddAndCutService AddAndCutService;
	
	
	@RequestMapping(value="/upload")
	public void uploadFile(
			@RequestParam(value = "file", required = false) MultipartFile file,
			AddandCut model,
			HttpServletRequest request,HttpServletResponse response) throws MalformedURLException{
		//System.out.println("上传开始！");
		//String path = request.getSession().getServletContext().getRealPath("upload");  
		
		// 设置编码
		response.setContentType("text/html;charset=UTF-8");
		
		String path = request.getServletContext().getRealPath("/upload");
		String fileName = new Date().getTime()+ ".jpg";
		File targetfile = new File(path, fileName);
		if (!targetfile.exists()){
			targetfile.mkdirs();
		}
		model.setPictureurl(request.getContextPath()+"/upload/"+fileName);
		
		//通过Service把记录保存到数据库
		AddAndCutService.SaveAnRecord(model);
		
		//把图片保存到指定的位置
		try {
			file.transferTo(targetfile);
		} catch (Exception e) {
			ExceptionUtil.throwRuntimeException("文件上传失败。");
			e.printStackTrace();
		}
	/*	ModelAndView modelAndView = new ModelAndView("long/add_cut/result");
		modelAndView.addObject("status", "sucess");
		modelAndView.addObject("model",model);
		
		return modelAndView;
	*/
		try {
			response.getWriter().println("<div  style='color: blue; font-size: 25px'>信息提交成功！</div>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return;
	}

}
