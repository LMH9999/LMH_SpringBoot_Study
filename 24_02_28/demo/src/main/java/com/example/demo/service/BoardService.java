package com.example.demo.service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.QnaVO;
import com.example.demo.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDAO boardDAO;
    private final MemberDAO memberDAO;

    public HashMap list(){
        HashMap result = new HashMap();
        result.put("board",boardDAO.list());
        return result;
    }

    public int write(QnaVO qnaVO) {
        int result = 0;
        result = boardDAO.write(qnaVO);
        if (result==0) {
            result = 400;
        }else {
            result = 200;
            int id = qnaVO.getId();
            // board에 insert된 값의 key값 id를 받아와서 그 값으로 다른 일 처리
            QnaVO recentVO = boardDAO.findById(id);
            UserVO userVO = new UserVO();
            userVO.setUserId(recentVO.getUserId());
            userVO.setUserName(recentVO.getUserId());
            memberDAO.write(userVO);
        }
        return result;
    }

    public int update(QnaVO qnaVO) {
        int result = 0;
        result = boardDAO.update(qnaVO);
        if (result==0) {
            result = 400;
        }else {
            result = 200;
        }
        return result;
    }

    public int delete(int id) {
        int result = 0;
        result = boardDAO.delete(id);
        if (result==0) {
            result = 400;
        }else {
            result = 200;
        }
        return result;
    }
}
