package com.itz.iwas.usecases.subscription_detail;

import com.itz.iwas.models.SubscriptionDum;
import com.itz.iwas.usecases.subscription_detail.pojo.SubscriptionPojo;
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
}