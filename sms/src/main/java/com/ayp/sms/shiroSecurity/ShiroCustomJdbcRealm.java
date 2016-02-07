package com.ayp.sms.shiroSecurity;
/**
 * 
 * @author rana
 * 
 */

import org.apache.shiro.realm.jdbc.JdbcRealm;

public final class ShiroCustomJdbcRealm extends JdbcRealm {

    public ShiroCustomJdbcRealm() {
        super();
        this.dataSource = MysqlDatabaseConnectionLoader.getDataSource();
    }
}
