package lxy.demo.transactional.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class HelloDao {

	@Inject
	JdbcTemplate jdbcTemplate;

	public void deleteCouponType(String id) {
		String sql = "UPDATE  coupon_type set isdel=1 where id =?";
		jdbcTemplate.update(sql, id);
	}

	public void deleteCouponByTypeID(String id) {

		String sql = "UPDATE  coupons set state=3 where type_id =?";
		jdbcTemplate.update(sql, id);
	}
}
