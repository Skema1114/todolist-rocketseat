package br.com.rafaelmartins.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rafaelmartins.todolist.user.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

	@Autowired
	private IUserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var servletPath = request.getServletPath();
		if (servletPath.startsWith("/tasks/")) {
			var authorization = request.getHeader("Authorization");
			var encodedAuth = authorization.substring("Basic".length()).trim();

			byte[] decodedAuth = Base64.getDecoder().decode(encodedAuth);
			var stringAuth = new String(decodedAuth);

			String[] credentials = stringAuth.split(":");
			String username = credentials[0];
			String password = credentials[1];


			var user = this.userRepository.findByUsername(username);
			if (user == null) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			} else {
				var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
				if (passwordVerify.verified) {
					request.setAttribute("idUser", user.getId());
					filterChain.doFilter(request, response);
				} else {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}
}
