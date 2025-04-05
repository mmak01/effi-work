package com.example.effiwork.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // TODO CSRFを一時的に無効化（開発・テスト）
				.authorizeHttpRequests(
						authz -> authz.requestMatchers("/css/**", "/js/**", "/img/**").permitAll() // 認証不要
								.requestMatchers("/", "/auth/login", "/auth/signup").permitAll() // 認証不要
								.anyRequest().authenticated())
				.formLogin(login -> login
						.loginPage("/auth/login") // ログインページ
						.loginProcessingUrl("/auth/doLogin") // ログイン成功後リダイレクト先
						.failureUrl("/login?error=true") // エラー時のリダイレクト
						.defaultSuccessUrl("/user", true) // ログイン成功後のリダイレクト先
						.usernameParameter("email") // ユーザー名フィールドのname
						.passwordParameter("password") // パスワードフィールドのname
				).logout(logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // ログアウトリクエストのURLパターン
						.logoutSuccessUrl("/auth/login") // ログアウト成功後のリダイレクト先
						.invalidateHttpSession(true) // ログアウト時にHTTPセッション無効化
						.deleteCookies("JSESSIONID") // 特定のクッキー削除
				);

		return http.build();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // パスワードハッシュ化
	}
}
