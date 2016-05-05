package lxy.demo.transactional.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lxy.demo.transactional.dao.HelloDao;

@Service
public class HelloService {

	@Inject
	HelloDao helloDao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void deleteCouponType(String id) {

		helloDao.deleteCouponType(id);
		if("aa".length()>1)
			throw new RuntimeException();
		helloDao.deleteCouponByTypeID(id);
	}

}
