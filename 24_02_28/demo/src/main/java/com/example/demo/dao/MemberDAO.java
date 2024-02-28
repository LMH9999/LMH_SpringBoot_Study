package com.example.demo.dao;

import com.example.demo.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    @Resource(name = "memberSqlSessionTemplate")
    private final SqlSession memberSqlSession;

    public List list(){
        return memberSqlSession.selectList("member.list"); //List<UserVO>
    }

    public void write(UserVO userVO) {
        memberSqlSession.insert("member.write",userVO);
    }
}
