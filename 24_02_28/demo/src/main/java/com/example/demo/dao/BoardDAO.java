package com.example.demo.dao;

import com.example.demo.vo.QnaVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {

    @Resource(name = "boardSqlSessionTemplate")
    private final SqlSession boardSqlSession;

    public List list(){
        return boardSqlSession.selectList("board.list"); //List<QnaVO>
    }

    public int write(QnaVO qnaVO) {
        return boardSqlSession.insert("board.write",qnaVO);
    }

    public QnaVO findById(int id) {
        return boardSqlSession.selectOne("board.findById",id);
    }

    public int update(QnaVO qnaVO) {
        return boardSqlSession.update("board.update",qnaVO);
    }

    public int delete(int id) {
        return boardSqlSession.delete(("board.delete"),id);
    }
}
