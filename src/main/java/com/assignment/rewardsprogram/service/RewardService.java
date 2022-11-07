package com.assignment.rewardsprogram.service;

import com.assignment.rewardsprogram.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    @Autowired
    RewardRepository rewardRepository;

    public Long getRewardsByUserId (Long userId) {
        return rewardRepository.getLastThreeMonthsRewardsByUserId(userId);
    }

    public Long getRewards () {
        return rewardRepository.getLastThreeMonthsRewards();
    }
}
