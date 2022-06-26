package info.pkg.sample.web;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import info.pkg.sample.controller.SimpleController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SimpleControllerTests {

	private MockMvc mvc;

	@Autowired
	private SimpleController target;

    @Before
    public void setup() {
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/resources/templates/");
        viewResolver.setSuffix(".html");

    	mvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
    }

    @Test
    public void testindex() throws Exception{
    	//コントローラーパスが正しいことを確認
    	MvcResult rslt = mvc.perform(get("/").with(user("pkg").roles("ADMIN")))
    			.andExpect(status().isOk())
    			.andExpect(view().name("index")).andReturn();

    	assertThat(rslt.getModelAndView().getViewName(),is("index"));
    	System.out.println("[testindex]:"+"OK");

    	//出力しているhtmlが正しいことを確認
//    	String content = rslt.getRequest().getContentAsString();
//    	assertThat(content,containsString("ログイン</a>"));
//    	assertThat(content,containsString("書籍検索</a>"));
//    	assertThat(content,containsString("書籍登録</a>"));
    }

    @Test
    public void testlogin() throws Exception{
    	//コントローラーパスが正しいことを確認
    	MvcResult rslt = mvc.perform(get("/login").with(user("pkg").roles("ADMIN")))
    			.andExpect(status().isOk())
    			.andExpect(view().name("login")).andReturn();

    	assertThat(rslt.getModelAndView().getViewName(),is("login"));
    	System.out.println("[loginindex]:"+"OK");

    	//出力しているhtmlが正しいことを確認
//    	String content = rslt.getResponse().getContentAsString();
//    	assertThat(content,containsString("ログインID"));
//    	assertThat(content,containsString("パスワード"));
    }


    /**
     * Top page tests
     */
//    @Test
//    public void testGet_topPage_hasNotAuth() throws Exception {
//        MvcResult result = this.mvc.perform(get("/"))
//                .andExpect(status().isOk()).andReturn();
//        String content = result.getResponse().getContentAsString();

//        assertThat(content, containsString(">ログイン</a>"));
//        assertThat(content, containsString(">書籍検索</a>"));
//        assertThat(content, not(containsString(">書籍登録</a>"))); // has not auth
//    }

//    @Test
//    public void testGet_topPage_hasAuthUser() throws Exception {
//        MvcResult result = this.mvc.perform(get("/").with(user("sbt").roles("USER")))
//                .andExpect(status().isOk()).andReturn();
//        String content = result.getResponse().getContentAsString();

//        assertThat(content, not(containsString(">ログイン</a>"))); // authenticated
//        assertThat(content, containsString(">書籍検索</a>"));
//        assertThat(content, not(containsString(">書籍登録</a>"))); // has not auth
//    }

//    @Test
//    public void testGet_topPage_hasAuthAdmin() throws Exception {
//        MvcResult result = this.mvc.perform(get("/").with(user("admin").roles("ADMIN")))
//                .andExpect(status().isOk()).andReturn();
//        String content = result.getResponse().getContentAsString();

//        assertThat(content, not(containsString(">ログイン</a>"))); // authenticated
//        assertThat(content, containsString(">書籍検索</a>"));
//        assertThat(content, containsString(">書籍登録</a>")); // has auth
//    }

    /**
     * Login tests
     */
//    @Test
//    public void testGet_login() throws Exception {
//        MvcResult result = this.mvc.perform(get("/login"))
//                .andExpect(status().isOk()).andReturn();
//        String content = result.getResponse().getContentAsString();

//        assertThat(content, containsString(">ログインID<"));
//        assertThat(content, containsString(">パスワード<"));
//        assertThat(content, not(containsString(">ログアウト<")));
//    }
}
