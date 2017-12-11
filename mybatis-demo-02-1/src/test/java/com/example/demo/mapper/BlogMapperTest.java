package com.example.demo.mapper;

import com.example.demo.domain.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class BlogMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectBlog() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog = session.selectOne(
                    "com.example.demo.mapper.BlogMapper", 101);
        } finally {
            session.close();
        }
    }

}