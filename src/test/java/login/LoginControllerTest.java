package login;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import practice.user.model.UserVo;
import test.WebTestConfig;

public class LoginControllerTest extends WebTestConfig {

	/**
	* Method : testLoginView
	* 작성자 : PC03
	* 변경이력 :
	* Method 설명 : 로그인 화면 요청 테스트
	 * @throws Exception 
	*/
	@Test
	public void testLoginView() throws Exception {
		MvcResult mvcResult =mockMvc.perform(get("/login")).andReturn();
		ModelAndView mav =mvcResult.getModelAndView();
		String viewName= mav.getViewName();

		assertEquals("login/login", viewName);
	}
	/**
	* Method : testLoginProcess_success
	* 작성자 : PC03
	* 변경이력 :
	* Method 설명 : 사용자 로그인 요청 성공 테스트
	 * @throws Exception 
	*/
	@Test
	public void testLoginProcess_success() throws Exception{
		/***Given***/
		
		/***When***/
		MvcResult mvcResult =mockMvc.perform(post("/loginPage").param("userId", "brown").param("pass", "brown1234")).andReturn();
		MockHttpServletRequest req =mvcResult.getRequest();
		HttpSession session = req.getSession();
		UserVo vo = (UserVo) session.getAttribute("userVo");
		
		//viewName
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		/***Then***/
		assertEquals("main", viewName);
		assertEquals("brown", vo.getMem_id());
		
	}

}
