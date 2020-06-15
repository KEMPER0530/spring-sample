package info.akazawa.sample.web;

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

import info.akazawa.sample.controller.BookController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTests {

    @Autowired
    private MockMvc mvc;

	@Autowired
	private BookController target;

    @Before
    public void setup() {
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    	viewResolver.setPrefix("/WEB-INF/resources/templates/");
    	viewResolver.setSuffix(".html");

    	mvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
    }

    @Test
    public void testindex2() throws Exception{
    	//コントローラーパスが正しいことを確認
    	MvcResult rslt = mvc.perform(get("/book").with(user("akazawa").roles("ADMIN")))
    			.andExpect(status().isOk())
    			.andExpect(view().name("book")).andReturn();

    	assertThat(rslt.getModelAndView().getViewName(),is("book"));
    	System.out.println("[bookindex2]:"+"OK");

    }


//    @Before
//    public void setup() {
//        this.mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }

    /**
     * Top page tests
     */
//    @Test
//    public void testGet_topPage_hasNotAuth() throws Exception {
//        this.mvc.perform(get("/book")).andExpect(status().is3xxRedirection());
//    }
/*
    @Test
    public void testGet_topPage_hasAuthUser() throws Exception {
        MvcResult result = this.mvc.perform(get("/book").with(user("sbt").roles("USER")))
                .andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();

        assertThat(content, not(containsString(">ログアウト</a>"))); // authenticated
        assertThat(content, containsString(">書籍検索</a>"));
        assertThat(content, not(containsString(">書籍登録</a>"))); // has not auth
    }

    @Test
    public void testGet_topPage_hasAuthAdmin() throws Exception {
        MvcResult result = this.mvc.perform(get("/").with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();

        assertThat(content, not(containsString(">ログイン</a>"))); // authenticated
        assertThat(content, containsString(">書籍検索</a>"));
        assertThat(content, containsString(">書籍登録</a>")); // has auth
    }


*/

}
