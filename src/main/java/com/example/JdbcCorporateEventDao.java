package com.example;

import com.example.domain.BatchJobExecution;
import com.example.domain.BatchJobExecutionId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by yangwj5 on 2017/3/21 at 20:56.
 */

@Repository
public class JdbcCorporateEventDao {


    private DataSource dataSource;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    public  final String select_sql = "select  JOB_EXECUTION_ID,VERSION,JOB_INSTANCE_ID,CREATE_TIME from batch_job_execution where job_execution_id = :id";


    public List getList(String id){

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",id);
        List list = namedParameterJdbcTemplate.query(select_sql, map, new RowMapper<List>() {
            public List mapRow(ResultSet resultSet, int i) throws SQLException {
                List lo = new ArrayList();
                lo.add(resultSet.getBigDecimal(1));
                lo.add(resultSet.getBigDecimal(2));
                lo.add(resultSet.getBigDecimal(3));
                lo.add(resultSet.getDate(4));
                return lo;
            }
        });
        return list;
    }

    public List<BatchJobExecution> getListViaObject(BatchJobExecutionId jobExecution){

//        SqlParameterSource nameParameters = new BeanPropertySqlParameterSource(jobExecution);
//        List list = namedParameterJdbcTemplate.queryForList(select_sql, nameParameters,List.class);
        Map<String,String> map = new HashMap<String, String>();
        map.put("id",jobExecution.getId().toString());
        List list = namedParameterJdbcTemplate.queryForList(select_sql,map);

        return list;
    }




    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

}
