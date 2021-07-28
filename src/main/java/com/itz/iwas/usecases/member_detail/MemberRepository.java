package com.itz.iwas.usecases.member_detail;

import com.itz.iwas.models.Membership;
import com.itz.iwas.usecases.member_detail.pojo.MembershipPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Membership, Integer> {
    @Query(value = "SELECT JoiningDate , MemberNumber , MemberName, FatherName," +
            "Designation, PermanentAddress, PermanentCity, MobileNumber, WhatsappNumber," +
            "AadharNumber, CurrentAddress, CurrentCity, SubscriberType, Amount FROM Membership " +
            "where id = ?1 And IsActive=1 ", nativeQuery = true)
    MembershipPojo findById(int pk0);

    Membership findByMemberNumber(String memberNumber);

    @Query(value = "select * from Membership where JoiningDate Between ?1 and ?2 Where IsActive=1 ", nativeQuery = true)
    List<MembershipPojo> findByJoiningDateBetween(Date fromDate, Date toDate);

    @Query(value = "SELECT count(MemberNumber) as totalMember FROM Membership Where IsActive=1 ", nativeQuery = true)
    String countMemberNumber();

    @Query(value = "select count(MemberNumber) from Membership where JoiningDate Between ?1 and ?2 AND IsActive=1 ", nativeQuery = true)
    String countMemberNumberByYear(Date fromDate, Date toDate);

}
