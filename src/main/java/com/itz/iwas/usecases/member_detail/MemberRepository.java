package com.itz.iwas.usecases.member_detail;

import com.itz.iwas.models.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Membership, Integer> {
    Membership findById(int pk0);

    Membership findByMemberNumber(String memberNumber);
}
