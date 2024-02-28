package com.example.demo.service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.dao.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDAO memberDAO;

    public HashMap list(){
        HashMap result = new HashMap();
        result.put("member", memberDAO.list());
        return result;
    }
}
