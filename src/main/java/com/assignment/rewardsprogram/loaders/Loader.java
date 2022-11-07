package com.assignment.rewardsprogram.loaders;

import com.assignment.rewardsprogram.model.Transaction;
import com.assignment.rewardsprogram.model.User;
import com.assignment.rewardsprogram.repository.TransactionRepository;
import com.assignment.rewardsprogram.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Loader {

    private static final Logger LOGGER = LoggerFactory.getLogger(Loader.class);

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @PostConstruct
    public void loadDummyDate () {
        loadUsersData();
        loadTransactionData();
    }

    public void loadUsersData () {
        Resource resource = resourceLoader.getResource("classpath:static/users.csv");
        try {
            File file = resource.getFile();
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String[] attributes = sc.next().split(",");
                userRepository.addUser(new User(Long.parseLong(attributes[0]), attributes[1]));
            }
            sc.close();
            LOGGER.info(userRepository.getUserList().stream().map(User::toString).collect(Collectors.joining("\n")));
        } catch (IOException e) {
            LOGGER.error("Exception occurred while trying to open file");
            throw new RuntimeException(e);
        }
    }

    public void loadTransactionData () {
        Resource resource = resourceLoader.getResource("classpath:static/transactions.csv");
        try {
            File file = resource.getFile();
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String[] attributes = sc.next().split(",");
                transactionRepository.addTransaction(new Transaction(Long.parseLong(attributes[0]), Long.parseLong(attributes[1]), Double.parseDouble(attributes[2]), new SimpleDateFormat("dd/MM/yyyy").parse(attributes[3])));
            }
            sc.close();
            LOGGER.info(transactionRepository.getTransactionList().stream().map(Transaction::toString)
                .collect(Collectors.joining("\n")));
        } catch (IOException e) {
            LOGGER.error("Exception occurred:", e.getStackTrace());
            throw new RuntimeException(e);
        } catch (ParseException e) {
            LOGGER.error("Exception occurred:", e.getStackTrace());
            throw new RuntimeException(e);
        }
    }
}
