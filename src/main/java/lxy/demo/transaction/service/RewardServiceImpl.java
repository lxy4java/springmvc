package lxy.demo.transaction.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lxy.demo.transaction.bean.Reward;
import lxy.demo.transaction.dao.IApi_userDao;
import lxy.demo.transaction.dao.RewardDao;

@Service
public class RewardServiceImpl {

	@Autowired
	private RewardDao rewardDao;
	@Autowired
	private IApi_userDao api_userDao;

	@Transactional("transactionManager")
	public void save(Reward reward) {

		rewardDao.save(reward);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", 1);
		params.put("money", reward.getMoney());
		params.put("user_id", reward.getUser_id());
		if (2 == 2) {
			throw new RuntimeException();
		}
		api_userDao.updateMoney(params);
	}

	public List<Reward> query(Reward reward) {
		// TODO Auto-generated method stub
		return rewardDao.query(reward);
	}

}
