package com.aps.testing.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aps.testing.cucumber.entity.CurrIdentityAddr;
import com.aps.testing.cucumber.entity.CurrIdentityLicense;
import com.aps.testing.cucumber.entity.CurrentIdentity;
import com.aps.testing.util.DbConfig;
@Service("currentIdentity")
public class CurrentIdentityDAOImpl implements CurrentIdentityDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	public static String findCurrentIdentytyById = "Select CurrId.NAME_PREFIX,CurrId.NAME_SUFFIX,CurrId.FIRST_NAME,CurrId.LAST_NAME,CurrId.MIDDLE_NAME, CurrId.GENDER, CurrId.DOB, CurrId.DOD, CurrId.SSN, CurrId.NPI, "
			+ "CurrIdLic.LIC_EFF_DATE,CurrIdLic.LIC_TERM_DATE,CurrIdLic.LIC_STATE,"
			+ "CuurIdAddr.ADDR_LN_1,CuurIdAddr.ADDR_LN_2,CuurIdAddr.CITY,CuurIdAddr.STATE,CuurIdAddr.ZIPCODE \n"
			+ "from STAGE1.CURR_IDENTITY CurrId " + "JOIN STAGE1.CURR_IDENTITY_LICENSE CurrIdLic "
			+ "ON CurrId.IDENTITY_ID = CurrIdLic.IDENTITY_ID " + "JOIN CURR_IDENTITY_ADDR CuurIdAddr "
			+ "ON CurrId.IDENTITY_ID = CuurIdAddr.IDENTITY_ID " 
			+ "where CurrId.IDENTITY_ID =?";
	
	public static String findOrganizationCurrentIdentityById = "Select CurrId.BUSINESS_NAME,CurrId.LEGAL_NAME,CurrId.EIN, "
			+ "CurrIdLic.LIC_EFF_DATE,CurrIdLic.LIC_TERM_DATE,CurrIdLic.LIC_STATE,"
			+ "CuurIdAddr.ADDR_LN_1,CuurIdAddr.ADDR_LN_2,CuurIdAddr.CITY,CuurIdAddr.STATE,CuurIdAddr.ZIPCODE "
			+ "from STAGE1.CURR_IDENTITY CurrId " 
			+ "JOIN STAGE1.CURR_IDENTITY_LICENSE CurrIdLic "
			+ "ON CurrId.IDENTITY_ID = CurrIdLic.IDENTITY_ID " 
			+ "JOIN CURR_IDENTITY_ADDR CuurIdAddr "
			+ "ON CurrId.IDENTITY_ID = CuurIdAddr.IDENTITY_ID " 
			+ "where CurrId.IDENTITY_ID =?";

	@Override
	@Transactional(readOnly = true)
	public CurrentIdentity findIndividualCurrentIdentityAttrById(int currId) {
		return jdbcTemplate.queryForObject(findCurrentIdentytyById, new Object[] { currId }, new IdentityRowMapper());
	}

	@Override
	@Transactional(readOnly = true)
	public CurrentIdentity findOrganizationCurrentIdentityAttrById(int currId){
		return jdbcTemplate.queryForObject(findOrganizationCurrentIdentityById, new Object[] { currId }, new IdentityRowMapper());
	}
}


