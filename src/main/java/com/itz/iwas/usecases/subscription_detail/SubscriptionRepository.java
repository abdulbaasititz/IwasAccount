package com.itz.iwas.usecases.subscription_detail;

import com.itz.iwas.models.SubscriptionDum;
import com.itz.iwas.usecases.subscription_detail.pojo.SubscriptionPojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionDum, Integer> {

    @Query(value = "select mem.JoiningDate , mem.MemberNumber,mem.MemberName ,sub.Amount," +
            "sub.SubscriptionYear " +
            "from (Select MemberId as MemberId,SUM(Amount) as Amount," +
            "GROUP_CONCAT(SubscriptionYear) as SubscriptionYear From Subscription GROUP By MemberId )" +
            "sub LEFT JOIN Membership mem on sub.MemberId = mem.Id ORDER BY mem.id ASC", nativeQuery = true)
    List<SubscriptionPojo> getAllSubscription();

    @Query(value = "select mem.JoiningDate , mem.MemberNumber,mem.MemberName ,sub.Amount, " +
            "sub.SubscriptionYear " +
            "from (Select MemberId as MemberId,SUM(Amount) as Amount, " +
            "GROUP_CONCAT(SubscriptionYear) as SubscriptionYear From Subscription GROUP By MemberId ) " +
            "sub LEFT JOIN Membership mem on sub.MemberId = mem.Id ORDER BY mem.id ASC ",
            countQuery = "select count(sub.memUnique) from (SELECT count(*) as memUnique " +
                    "from Subscription group by MemberId) as sub", nativeQuery = true)
    Page<SubscriptionPojo> getSubscription(Pageable pg);

//    List<SubscriptionPojo> getSubscriptionByDate();

    @Query(value = "SELECT sum(Amount) as totalAmount FROM Subscription", nativeQuery = true)
    String totalAmount();

    @Query(value = "SELECT sum(Amount) as totalAmount FROM Subscription Where SubscriptionYear " +
            "Between ?1 and ?2", nativeQuery = true)
    String totalAmountByYear(String fromYear, String toYear);

    SubscriptionDum findByMemberIdAndSubscriptionYear(Integer memberId, String subYear);

    SubscriptionDum findByMemberId(Integer memberId);
}
