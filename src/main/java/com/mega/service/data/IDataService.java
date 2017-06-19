package com.mega.service.data;

/**
 * 处理socket接受到信息
 * @author Andy
 *
 */
public interface IDataService {
	
	public static final String BEAN_ID = "service.dataService";
	
	/**
	 * 数据保存
	 * @param info
	 */
	void saveData(String info);

}
