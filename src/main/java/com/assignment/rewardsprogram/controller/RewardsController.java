package com.assignment.rewardsprogram.controller;

import com.assignment.rewardsprogram.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rewards")
public class RewardsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RewardsController.class);

    @Autowired
    RewardService rewardService;

    @GetMapping("/byUserId")
    public ResponseEntity<Long> getRewardsByUserId (@RequestParam Long userId) {
        LOGGER.info(String.format("Request: getRewardsByUserId :: userId: %s", userId));
        Long rewardPoints = rewardService.getRewardsByUserId(userId);
        ResponseEntity<Long> response = new ResponseEntity<>(rewardPoints, HttpStatus.OK);
        LOGGER.info(String.format("Response: getTotalRewards :: %s", response));
        return response;
    }

    @GetMapping("/getTotalRewards")
    public ResponseEntity<Long> getTotalRewards () {
        LOGGER.info(String.format("Request: getTotalRewards"));
        Long rewardPoints = rewardService.getRewards();
        ResponseEntity<Long> response = new ResponseEntity<>(rewardPoints, HttpStatus.OK);
        LOGGER.info(String.format("Response: getTotalRewards :: %s", response));
        return response;
    }


}
