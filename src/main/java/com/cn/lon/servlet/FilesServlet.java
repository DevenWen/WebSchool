package com.cn.lon.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cn.lon.entity.Files;
import com.cn.lon.service.impl.FilesService;
import com.cn.qpm.framework.context.WebSchoolContext;
import com.cn.qpm.usermanage.model.LoginUser;


@WebServlet("/FilesServlet")
public class FilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FilesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //实现service
    private FilesService filesService=new FilesService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作类型
		String method = request.getParameter("method");
		
		if("listTitles".equals(method)){
			listTitles(request,response);
		}
		else if("listTitlesToStu".equals(method)){
			listTitlesToStu(request,response);
		}
		else if("upload".equals(method)){
			upload(request,response);
		}
		else if("down".equals(method)){
			down(request,response);
		}
		else if("deletefile".equals(method)){
			deletefile(request,response);
		}
	}


	//删除文件
	private void deletefile(HttpServletRequest request,
			HttpServletResponse response) {
		
		//思路：先删除服务器上的文件，再删除数据库上关于该文件的数据信息
		
		try {
			//1.获取要查看公告的标题
			String title=request.getParameter("title");
				
			//2.获取文件对象
			Files files=filesService.findByTitle(title);
			
			//3.获得文件名
			String fileName=files.getFilename();
			
			//4.先获取上传目录路径
			String basePath = getServletContext().getRealPath("/upload");
			
			//5.得到带路径的文件，进行删除
			File file=new File(basePath,fileName);			
			file.delete();
			
			//6.调用方法进行删除公告信息
			filesService.deleteFiles(title);

			//7.跳转
			request.getRequestDispatcher("/FilesServlet?method=listTitles").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}


	//文件下载
	private void down(HttpServletRequest request, HttpServletResponse response) {
		try {
			//1.获取要查看公告的标题
			String title=request.getParameter("title");
			
			//2.获取文件对象
			Files files=filesService.findByTitle(title);
			
			//3.获得文件名
			String fileName=files.getFilename();
	//		fileName = new String(fileName.getBytes("ISO8859-1"),"UTF-8");

			// 先获取上传目录路径
			String basePath = getServletContext().getRealPath("/upload");
			// 获取一个文件流
			InputStream in = new FileInputStream(new File(basePath,fileName));
			
			// 设置下载的响应头
			response.setHeader("content-disposition", "attachment;fileName=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
			
			// 获取response字节流
			OutputStream out = response.getOutputStream();
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = in.read(b)) != -1){
				out.write(b, 0, len);
			}
			// 关闭
			out.close();
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}


	//在学生页面显示全部文件标题的内容
	private void listTitlesToStu(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.调用方法获取所有公告
			List<Files> list= filesService.getAll();
					
			//2.把结果保存到域对象中
			request.setAttribute("files",list);
			
			//3.跳转
			request.getRequestDispatcher("/view/long/files/ftitles_list_stu.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}


	//显示全部文件标题的内容
	private void listTitles(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//1.调用方法获取所有公告
			List<Files> list= filesService.getAll();
					
			//2.把结果保存到域对象中
			request.setAttribute("files",list);
			
			//3.跳转
			request.getRequestDispatcher("/view/long/files/ftitles_list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}


	//上传文件
	private void upload(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			// 1. 创建工厂对象
			FileItemFactory factory = new DiskFileItemFactory();
			// 2. 文件上传核心工具类
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置大小限制参数
			upload.setFileSizeMax(10*1024*1024);	// 单个文件大小限制
			upload.setSizeMax(50*1024*1024);		// 总文件大小限制
			upload.setHeaderEncoding("UTF-8");		// 对中文文件编码处理

			String filename=null;
			String title=null;
			String basePath=null;
			
			// 判断
			if (upload.isMultipartContent(request)) {
				// 3. 把请求数据转换为list集合
				List<FileItem> list = upload.parseRequest(request);
				// 遍历
				for (FileItem item : list){
					// 判断：普通文本数据
					if (item.isFormField()){
						// 获取文件标题
						title = item.getString("UTF-8");	
					//	title = URLEncoder.encode(title, "UTF-8");
					//	System.out.println(title);
					} 
					// 文件表单项
					else {
						/******** 文件上传 ***********/
						// a. 获取文件名称
						filename = item.getName();					
						// ----处理上传文件名重名问题----
						// a1. 先得到唯一标记
						String id = UUID.randomUUID().toString();
						// a2. 拼接文件名
						filename = id + filename;										
						
						// b. 得到上传目录
						basePath = getServletContext().getRealPath("/upload");		//路径
						// c. 创建要上传的文件对象
						File file = new File(basePath,filename);
						// d. 上传
						item.write(file);
						item.delete();  // 删除组件运行时产生的临时文件
					}
				}
			}
			
			if(filename!=null&title!=null&basePath!=null){
				//1.获取剩下数据
				LoginUser currentUser = WebSchoolContext.getCurrentUser();
				String uploadman=currentUser.getName();
				Date time=new Date();
				
				Files files=new Files();
				//2.封装
				files.setUploadman(uploadman);
				files.setFilename(filename);
				files.setTitle(title);
				files.setFileURL(basePath);
				files.setTime(time);
				
				//3.执行添加方法
				filesService.addFiles(files);
				
				//4.跳转
				request.getRequestDispatcher("/FilesServlet?method=listTitles").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
				
					
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
