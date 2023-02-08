package com.care.dbConfig.repository;

import org.springframework.stereotype.Repository;

import com.care.dbConfig.dto.MemberDTO;

@Repository
public interface MemberRepository {

	MemberDTO login(String id);

	void register(MemberDTO member);

}
