package com.itz.iwas.usecases.member_detail;

import com.itz.iwas.models.Membership;
import com.itz.iwas.usecases.member_detail.pojo.MembershipPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Membership, Integer> {
    @Query(value = "SELECT JoiningDate , MemberNumber , MemberName, FatherName," +
            "Designation, PermanentAddress, PermanentCity, MobileNumber, WhatsappNumber," +
            "AadharNumber, CurrentAddress, CurrentCity, SubscriberType, Amount FROM Membership " +
            "where id = ?1 ", nativeQuery = true)
    MembershipPojo findById(int pk0);

    Membership findByMemberNumber(String memberNumber);
}
