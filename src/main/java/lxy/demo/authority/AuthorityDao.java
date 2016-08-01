package lxy.demo.authority;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityDao {

	@Inject
	JdbcTemplate jdbcTemplate;

	public List<String> getUserRoles(String usr) {
		String sql = "SELECT ROLE  FROM SYS_USR WHERE NAME =?";
		String roles = jdbcTemplate.queryForObject(sql, String.class, usr);
		return Arrays.asList(roles.split(","));
	}

	public List<AuthPages> getUserAuthPages(List<String> roles) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("roles", roles);
		String sql = "SELECT PAGES,PAGESAUTH  FROM SYS_ROLE WHERE NAME  IN(:roles) AND PAGESAUTH >7";
		List<AuthPages> authPages = namedParameterJdbcTemplate.query(sql, parameters, new RowMapper<AuthPages>() {
			@Override
			public AuthPages mapRow(ResultSet rs, int ind) throws SQLException {
				AuthPages  ap =new AuthPages();
				ap.setPAGES(rs.getString("PAGES"));
				ap.setPAGESAUTH(rs.getInt("PAGESAUTH"));
				return ap;
			}
		});
		return authPages;
	}
}
