package com.toloan.pay.enums;



/**
 * 公用常量类定义
 *
 * @version 1.0
 * @author 吴国成f
 */
public class Constant {

	/** session用户 **/
	public static final String SESSION_OPERATOR = "session_operator";

	/**  角色session 暂用*/
	public static final String ROLEID = "roleId";

	public static final String INSERT = "create";

	public static final String UPDATE = "update";

	public static final String ACCESSCODE = "accessCode";

	public static final String RESPONSE_CODE = "code";

	public static final String RESPONSE_CODE_MSG = "msg";

	public static final String RESPONSE_DATA = "data";
	public static final String RESPONSE_DATA2 = "data2";
	public static final String RESPONSE_DATA3 = "data3";

	public static final String RESPONSE_DATA_TOTAL = "total";

	public static final String RESPONSE_DATA_TOTALCOUNT = "totalCount";

	public static final String RESPONSE_DATA_CURRENTPAGE = "currentPage";

	public static final String RESPONSE_DATA_PAGE = "page";


	public static final String OPERATION_SUCCESS = "操作成功";

	public static final String OPERATION_FAIL = "操作失败";

	public static final int SIGN_FAIL = 99; // 验签失败

	public static final int SUCCEED_CODE_VALUE = 200; // 成功 插入 、删除 更新 修改

	public static final int FAIL_CODE_PARAM_INSUFFICIENT = 300;	//参数列表不完整 

	public static final int FAIL_CODE_VALUE = 400; // 失败 插入 、删除 更新 修改

	public static final int FAIL_CODE_PWD = 401; // 交易密码错误

	public static final int PERM_CODE_VALUE = 403; // 无权限访问

	//wangxb增加
	public static final int BiZ_IN_BLACKLIST = 404; // 在黑名单中不予操作

	public static final int BiZ_NO_USER = 405; // 用户不存在

	public static final int OTHER_CODE_VALUE = 500; // 其他异常

	public static final int NOSESSION_CODE_VALUE = 800; // session失效

	public static final int CLIENT_EXCEPTION_CODE_VALUE = 998; // 连接异常（除请求超时）

	public static final int TIMEOUT_CODE_VALUE = 999; // 请求超时

	public static final String REJECT_REASON1 = "501";//mongo查询不到通讯录,或者通讯录小于20个
	public static final String REJECT_REASON2 = "502";//复借用户-逾期天数大于等于7天，直接拒绝
	public static final String REJECT_REASON3 = "503";//复借用户-同盾复借规则拒绝
	public static final String REJECT_REASON4 = "504";//新用户-个人信息自定义规则拒绝
	public static final String REJECT_REASON5= "505";//新用户-运营商在网时长自定义规则拒绝
	public static final String REJECT_REASON6 = "506";//新用户-紧急联系人拒绝
	public static final String REJECT_REASON7 = "507";//新用户-芝麻分自定义规则拒绝
	public static final String REJECT_REASON8 = "508";//规则匹配结果命中不通过
	public static final String REJECT_REASON9= "509";//借款审核失败
	public static final String REJECT_REASON10 = "510";//用户画像规则，规则匹配结果命中不通过
	public static final String REJECT_REASON11 = "511";//审核不通过 （自动审核不通过，人工复审不通过）
	public static final String REJECT_REASON12= "512";//查询不到通讯录,或者通讯录小于20个
	public static final String REJECT_REASON13 = "513";//复借用户逾期天数大于等于7天
	public static final String REJECT_REASON14= "514";//同盾复借规则
	public static final String REJECT_REASON15= "515";//个人信息自定义规则
	public static final String REJECT_REASON16= "516";//运营商在网时长自定义规则
	public static final String REJECT_REASON17= "517";//芝麻分自定义规则
	public static final String REJECT_REASON18= "518";//风控自定义规则增加通讯录少于20个时直接拒绝的规则
	public static final String REJECT_REASON19= "519";//风控自定义规则  复借用户 复借成功大于5次的用户：逾期次数>3,拒绝
	public static final String REJECT_REASON20= "520";//风控自定义规则  复借用户 逾期总天数>5，拒绝
	public static final String REJECT_REASON21= "521";//连续复借失败次数>3次的  拒绝    （可配置）
	public static final String REJECT_REASON22= "522";//不在白名单内拒绝

}
