package lxy.demo.transaction.bean;

import java.util.Date;

/**
 * 
 * author : zyk comments:用户表（手表，手机）实体类型 create date:2016-08-23 17:23:18
 */
public class Api_user {
	// 用户id
	private Integer user_id;
	// 用户唯一标识
	private String user_uuid;
	// 用户名
	private String user_name;
	// 昵称
	private String nick_name;
	// 真实姓名
	private String real_name;
	// 密码
	private String password;
	// 性别：1男，2女
	private Integer sex;
	// 用户身高
	private Integer user_height;
	// 用户体重
	private Integer user_weight;
	// 头像地址
	private String header_img_url;
	// 绑定的邮箱
	private String email_binded;
	// 绑定的手机号
	private String phone_num_binded;
	// 绑定的手表串号
	private String watch_imei_binded;
	// 用户类型，1：家长，2：孩子
	private Integer role_type;
	// 用户状态:1正常，2：停用
	private Integer user_status;
	// 创建时间
	private Date create_time;
	// 生日
	private Date birthday;
	// 热艾手表 唯一标识ID
	private String cid;
	//
	private Integer honor;
	private String school;
	private String grade;
	private String motto;
	private int ispay;
	private Date payDate;
	private Date dueDate;
	private int reporterStation;
	private int score;
	private int reporterLevel;
	private String reporterNo;
	private int auditStatus;

	/**
	 * 获取用户id的值
	 * 
	 * @return :
	 */
	public Integer getUser_id() {
		return user_id;
	}

	/**
	 * 设置用户id的值
	 * 
	 * @param user_id
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	/**
	 * 获取用户唯一标识的值
	 * 
	 * @return :
	 */
	public String getUser_uuid() {
		return user_uuid;
	}

	/**
	 * 设置用户唯一标识的值
	 * 
	 * @param user_uuid
	 */
	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	/**
	 * 获取用户名的值
	 * 
	 * @return :
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * 设置用户名的值
	 * 
	 * @param user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * 获取昵称的值
	 * 
	 * @return :
	 */
	public String getNick_name() {
		return nick_name;
	}

	/**
	 * 设置昵称的值
	 * 
	 * @param nick_name
	 */
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	/**
	 * 获取真实姓名的值
	 * 
	 * @return :
	 */
	public String getReal_name() {
		return real_name;
	}

	/**
	 * 设置真实姓名的值
	 * 
	 * @param real_name
	 */
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	/**
	 * 获取密码的值
	 * 
	 * @return :
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码的值
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取性别：1男，2女的值
	 * 
	 * @return :
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 设置性别：1男，2女的值
	 * 
	 * @param sex
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 获取用户身高的值
	 * 
	 * @return :
	 */
	public Integer getUser_height() {
		return user_height;
	}

	/**
	 * 设置用户身高的值
	 * 
	 * @param user_height
	 */
	public void setUser_height(Integer user_height) {
		this.user_height = user_height;
	}

	/**
	 * 获取用户体重的值
	 * 
	 * @return :
	 */
	public Integer getUser_weight() {
		return user_weight;
	}

	/**
	 * 设置用户体重的值
	 * 
	 * @param user_weight
	 */
	public void setUser_weight(Integer user_weight) {
		this.user_weight = user_weight;
	}

	/**
	 * 获取头像地址的值
	 * 
	 * @return :
	 */
	public String getHeader_img_url() {
		return header_img_url;
	}

	/**
	 * 设置头像地址的值
	 * 
	 * @param header_img_url
	 */
	public void setHeader_img_url(String header_img_url) {
		this.header_img_url = header_img_url;
	}

	/**
	 * 获取绑定的邮箱的值
	 * 
	 * @return :
	 */
	public String getEmail_binded() {
		return email_binded;
	}

	/**
	 * 设置绑定的邮箱的值
	 * 
	 * @param email_binded
	 */
	public void setEmail_binded(String email_binded) {
		this.email_binded = email_binded;
	}

	/**
	 * 获取绑定的手机号的值
	 * 
	 * @return :
	 */
	public String getPhone_num_binded() {
		return phone_num_binded;
	}

	/**
	 * 设置绑定的手机号的值
	 * 
	 * @param phone_num_binded
	 */
	public void setPhone_num_binded(String phone_num_binded) {
		this.phone_num_binded = phone_num_binded;
	}

	/**
	 * 获取绑定的手表串号的值
	 * 
	 * @return :
	 */
	public String getWatch_imei_binded() {
		return watch_imei_binded;
	}

	/**
	 * 设置绑定的手表串号的值
	 * 
	 * @param watch_imei_binded
	 */
	public void setWatch_imei_binded(String watch_imei_binded) {
		this.watch_imei_binded = watch_imei_binded;
	}

	/**
	 * 获取用户类型，1：家长，2：孩子的值
	 * 
	 * @return :
	 */
	public Integer getRole_type() {
		return role_type;
	}

	/**
	 * 设置用户类型，1：家长，2：孩子的值
	 * 
	 * @param role_type
	 */
	public void setRole_type(Integer role_type) {
		this.role_type = role_type;
	}

	/**
	 * 获取用户状态:1正常，2：停用的值
	 * 
	 * @return :
	 */
	public Integer getUser_status() {
		return user_status;
	}

	/**
	 * 设置用户状态:1正常，2：停用的值
	 * 
	 * @param user_status
	 */
	public void setUser_status(Integer user_status) {
		this.user_status = user_status;
	}

	/**
	 * 获取创建时间的值
	 * 
	 * @return :
	 */
	public Date getCreate_time() {
		return create_time;
	}

	/**
	 * 设置创建时间的值
	 * 
	 * @param create_time
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * 获取生日的值
	 * 
	 * @return :
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 设置生日的值
	 * 
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 获取热艾手表 唯一标识ID的值
	 * 
	 * @return :
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * 设置热艾手表 唯一标识ID的值
	 * 
	 * @param cid
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * 获取的值
	 * 
	 * @return :
	 */
	public Integer getHonor() {
		return honor;
	}

	/**
	 * 设置的值
	 * 
	 * @param honor
	 */
	public void setHonor(Integer honor) {
		this.honor = honor;
	}

	/**
	 * 学校
	 * 
	 * @return
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * 学校
	 * 
	 * @param school
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * 班级
	 * 
	 * @return
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 班级
	 * 
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 座右铭
	 * 
	 * @return
	 */
	public String getMotto() {
		return motto;
	}

	/**
	 * 座右铭
	 * 
	 * @param motto
	 */
	public void setMotto(String motto) {
		this.motto = motto;
	}

	/**
	 * 小记者年费支付时间
	 * 
	 * @return
	 */
	public Date getPayDate() {
		return payDate;
	}

	/**
	 * 小记者年费支付时间
	 * 
	 * @param payDate
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	/**
	 * 小记者年费过期时间
	 * 
	 * @return
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * 小记者年费过期时间
	 * 
	 * @param dueDate
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * 小记者站
	 * 
	 * @return
	 */
	public int getReporterStation() {
		return reporterStation;
	}

	/**
	 * 小记者站
	 * 
	 * @param reporterStation
	 */
	public void setReporterStation(int reporterStation) {
		this.reporterStation = reporterStation;
	}

	/**
	 * 是否支付小记者年费 0=否 1=是
	 * 
	 * @return
	 */
	public int getIspay() {
		return ispay;
	}

	/**
	 * 是否支付小记者年费 0=否 1=是
	 * 
	 * @param ispay
	 */
	public void setIspay(int ispay) {
		this.ispay = ispay;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getReporterLevel() {
		return reporterLevel;
	}

	public void setReporterLevel(int reporterLevel) {
		this.reporterLevel = reporterLevel;
	}

	public String getReporterNo() {
		return reporterNo;
	}

	public void setReporterNo(String reporterNo) {
		this.reporterNo = reporterNo;
	}

	/**
	 * 小记者实名审核状态  0=初始状态（未审核）1=待审核 2=审核通过 3=审核失败
	 * 
	 * @return
	 */
	public int getAuditStatus() {
		return auditStatus;
	}

	/**
	 * 小记者实名审核状态  0=初始状态（未审核）1=待审核 2=审核通过 3=审核失败
	 * 
	 * @param auditStatus
	 */
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}

}
