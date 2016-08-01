package lxy.demo.authority;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

	@Inject
	AuthorityDao authorityDao;

	public List<String> getUserRoles(String usr) {

		return authorityDao.getUserRoles(usr);
	}

	public HashMap<String, Integer> getUserAuthPages(List<String> roles) {
		List<AuthPages> authPages = authorityDao.getUserAuthPages(roles);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (AuthPages ap : authPages) {
			String page = ap.getPAGES();
			Integer auth = ap.getPAGESAUTH();
			if (map.containsKey(page)) {
				Integer mauth = map.get(page);
				map.put(page, (auth | mauth));
			} else {
				map.put(page, auth);
			}
		}
		return map;
	}

	public HashMap<String, Integer> getUserAuthPages(String usr) {
		return getUserAuthPages(getUserRoles(usr));
	}
}
