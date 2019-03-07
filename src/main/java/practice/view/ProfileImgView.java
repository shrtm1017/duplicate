package practice.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import practice.user.model.UserVo;
import practice.user.service.IUserService;

public class ProfileImgView implements View{
@Resource(name="userService")
private IUserService userService;
	@Override
	public String getContentType() {
		return "image";
	}
	//개발?��?�� ?��미�? 경로�? model객체?�� "path"?��?�� ?��?��?���? ?��?��?��?��.
	
	//개발?��?�� ?��?��?�� ?��?��?���? model객체?�� userId?��?�� ?��?��?���? ?��?��?��
	@Override
	public void render(Map<String, ?> model,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		response.setContentType("image/png");
		String userId = (String) model.get("userId");
		//2.?��?�� ?��?��?�� ?��?��?���? ?��?��?�� ?���? 조회(realFilename)
		UserVo userVo = userService.selectUser(userId);
		//3-1.realFilename?�� 존재?�� 경우
		//3-1-1. ?��?�� 경로?�� ?��?��?�� FileInputStream ?���? ?��?��?��
		FileInputStream fis;
		if(userVo !=null&&userVo.getFile_path() !=null)
		fis =new FileInputStream(new File(userVo.getFile_title()));
		
		//3-2-1./upload/noimg.png(application.getRealPath())
		else{
			ServletContext application =request.getServletContext();
			String noimgpath = application.getRealPath("/upload/noimg.png");
			fis = new FileInputStream(new File(noimgpath));
		}
		//4.FileInputStream?�� response객체?? outputStream 객체?�� write
		ServletOutputStream sos =response.getOutputStream();
		byte[] buff = new byte[512];
		int len =0;
		while((len =fis.read(buff)) > -1){
			sos.write(buff);
		}
		sos.close();
		fis.close();

		
	}

}
