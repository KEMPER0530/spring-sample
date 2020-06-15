package info.akazawa.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import info.akazawa.sample.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

    @Autowired
    UserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {
    	System.out.println("【Show inspect the ignore-spring-security-ant-pattern!!!】");
    	System.out.println(environment.getProperty("security.ignore-spring-security-ant-pattern"));
    	// セキュリティ設定を無視するリクエスト設定
        // 静的リソースに対するアクセスはセキュリティ設定を無視する
        web.ignoring().antMatchers("/img/**", "/css/**", "/js/**", "/webjars/**","/h2-console/**","/actuator/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		// アクセス権限の設定
        		// アクセス制限の無いURL
                .antMatchers("/").permitAll()
                // その他は認証済みであること
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	// ログイン画面
                .loginPage("/login")
                // 認証処理
                // .loginProcessingUrl("/authenticate")
                // ログイン成功
                // .defaultSuccessUrl("/loginSuccess")
                // ログイン失敗
                .failureUrl("/login")
                // ユーザ名のパラメータ
                .usernameParameter("username")
                // パスワードのパラメータ
                .passwordParameter("password").permitAll().and()
            .logout()
            	// ログアウト処理
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // ログアウト成功時の遷移先
                .logoutSuccessUrl("/")
                // ログアウト時に削除するクッキー名
                .deleteCookies("JSESSIONID")
                // ログアウト時のセッション破棄を有効化
                .invalidateHttpSession(true).permitAll();
        		//	.and()
        //	.sessionManagement()
        		// セッションが無効な時の遷移先
        		// .invalidSessionUrl("/invalidSession");
    }

    /**
     * UserDetailsServiceインターフェースを実装した独自の認証レルムを使用する設定
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Configuration
//    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//        @Autowired
//        UserService userService;

//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
//        }
//    }
}