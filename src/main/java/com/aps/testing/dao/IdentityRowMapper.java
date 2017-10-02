package com.aps.testing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.aps.testing.cucumber.entity.CurrIdentityAddr;
import com.aps.testing.cucumber.entity.CurrIdentityLicense;
import com.aps.testing.cucumber.entity.CurrentIdentity;

public class IdentityRowMapper implements RowMapper<CurrentIdentity>{

	@Override
	public CurrentIdentity mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		CurrentIdentity currentIdentity = new CurrentIdentity();
		CurrIdentityLicense currIdentityLicense = new CurrIdentityLicense();
		CurrIdentityAddr currIdentityAddr = new CurrIdentityAddr();
		currentIdentity.setNamePrefix(rs.getString("NAME_PREFIX"));
		currentIdentity.setNameSuffix(rs.getString("NAME_SUFFIX"));
		currentIdentity.setFirstName(rs.getString("FIRST_NAME"));
		currentIdentity.setLastName(rs.getString("LAST_NAME"));
		currentIdentity.setMiddleName(rs.getString("MIDDLE_NAME"));
		currentIdentity.setGender(rs.getString("GENDER"));
		currentIdentity.setSsn(rs.getString("SSN"));
		currentIdentity.setNpi(rs.getString("NPI"));
		try {
			currentIdentity.setDob(simpleDateFormat.parse(rs.getString("DOB")));
			currIdentityLicense.setLicEffDate(simpleDateFormat.parse(rs.getString("LIC_EFF_DATE")));
			currIdentityLicense.setLicTermDate(simpleDateFormat.parse(rs.getString("LIC_TERM_DATE")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currIdentityLicense.setLicState(rs.getString("LIC_STATE"));
		currIdentityAddr.setAddrLn1(rs.getString("ADDR_LN_1"));
		currIdentityAddr.setAddrLn2(rs.getString("ADDR_LN_2"));
		currIdentityAddr.setCity(rs.getString("CITY"));
		currIdentityAddr.setState(rs.getString("STATE"));
		currIdentityAddr.setZipcode(rs.getString("ZIPCODE"));
		currentIdentity.setCurrIdentityLicense(currIdentityLicense);
		currentIdentity.setCurrIdentityAddr(currIdentityAddr);
		return currentIdentity;
	}

}
