package lxy.demo.transaction.dao;


import java.util.List;

import lxy.demo.transaction.bean.Reward;


public interface RewardDao {

	public void save(Reward reward);

	public List<Reward> query(Reward reward);

}
