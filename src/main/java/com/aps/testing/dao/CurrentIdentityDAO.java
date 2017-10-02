package com.aps.testing.dao;

import javax.sql.DataSource;

import com.aps.testing.cucumber.entity.CurrentIdentity;

import groovyjarjarcommonscli.ParseException;

public interface CurrentIdentityDAO {

	public CurrentIdentity findByCurrentIdentityAttrById(int currId) throws ParseException;
}
