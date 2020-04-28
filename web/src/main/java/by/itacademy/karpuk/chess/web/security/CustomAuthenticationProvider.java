package by.itacademy.karpuk.chess.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import by.itacademy.karpuk.chess.dao.api.entity.table.IPlayer;
import by.itacademy.karpuk.chess.service.IPlayerService;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private IPlayerService playerService;

// TODO inject UserService

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		final String nickname = authentication.getPrincipal() + "";
		final String password = authentication.getCredentials() + "";
		IPlayer player = playerService.getPlayerByNickname(nickname);

// TODO find use by username (unique)

		if (player == null) {
			throw new BadCredentialsException("1000");
		}

// TODO verify password (DB contains hash - not a plain password)
		if (player.getNickname().equals(nickname)) {
			if (!PasswordUtils.generateSecurePassword(password, player.getSalt()).equals(player.getPassword())) {
				throw new BadCredentialsException("1000");
			}

		}

		int playerId = player.getId(); // FIXME: it should be the real user id from DB

		List<String> userRoles = new ArrayList<>();// TODO get list of user's
// roles
		userRoles.add("ROLE_" + "admin"); // !!! ROLE_ prefix is required

		final List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (String roleName : userRoles) {
			authorities.add(new SimpleGrantedAuthority(roleName));
		}

		ExtendedToken token = new ExtendedToken(nickname, password, authorities);
		token.setId(playerId);
		return token;

	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}