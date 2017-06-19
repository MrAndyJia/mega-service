package com.mega.service.data.impl;

import java.util.UUID;

import org.hibernate.Session;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.mega.service.data.IDataService;
import com.mega.service.data.SocketInfo;

@Repository(IDataService.BEAN_ID)
public class DataServiceImpl extends org.springframework.orm.hibernate3.support.HibernateDaoSupport implements IDataService {

	@Override
	public void saveData(String data) {
		System.out.println("数据保存到数据库");
		Assert.notNull(data, "Socket信息为空");
		
		SocketInfo info = new SocketInfo();
		info.setId(UUID.randomUUID().toString());
		info.setCompanyId("soft");
		info.setDeviceId("1");
		info.setExcepTag("0");
		info.setInfo(data);
		
		//Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		//session.beginTransaction();
		//session.save(info);
		//session.getTransaction().commit();
        //if(null != session) session.close();
	}

}
