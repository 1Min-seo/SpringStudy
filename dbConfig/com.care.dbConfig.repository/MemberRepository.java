package com.care.dbConfig.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.dbConfig.dto.MemberDTO;

@Repository
public interface MemberRepository {
	//인터페이스에 미리 검색 메소드를 정의 해 두는 것으로, 메소드를 호출하는 것만으로
	//스마트한 검색을 할 수 있도록 한다.

	MemberDTO login(String id);

	void register(MemberDTO member);
	
	ArrayList<MemberDTO> list();
	
	void update(MemberDTO member);

	void delete(String id);

}
