package com.project.Member.repository;

import org.springframework.stereotype.Repository;
import com.project.Member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("select m.memberName from Member m where m.id = :id")
    String findNameById(@Param("id") int id);
}

