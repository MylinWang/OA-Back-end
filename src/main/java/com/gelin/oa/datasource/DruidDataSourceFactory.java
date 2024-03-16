package com.gelin.oa.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DruidDataSourceFactory extends UnpooledDataSourceFactory {



    @Override
    public DataSource getDataSource() {
        try {
            //init初始化
            ((DruidDataSource)this.dataSource).init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.dataSource;
    }


    public DruidDataSourceFactory() {
        //实例化DruidDataSource
        this.dataSource=new DruidDataSource();
    }
}
