# Rewards Program

## Prerequisites
Make sure you have the following prerequisites,

1. Java with v1.8.0+
2. Apache Maven v3.8.6
3. Intellij
4. Postman

## Flow of the code
### Controller Layer
Although the flow starts from the `main` method of `RewardsprogramApplication`, the visible flow of the code starts  in the Controller layer.
We have 3 controllers defined here,
1. RewardsController
2. TransactionController
3. UserController

#### RewardsController
The base end point for the controller is "rewards" and we have 2 end points defined here.
1. `rewards/byUserId`

Get rewards for a given user by the userId, PFB for the request example.

```shell
curl --location --request GET 'localhost:8080/rewards/byUserId?userId=1234'
```

2. `rewards/getTotalRewards`

Get total reward points of all the users, PFB for the request example.

```shell
curl --location --request GET 'localhost:8080/rewards/getTotalRewards'
```

#### TransactionController
The base end point for the controller is "transactions" and we have 4 end points defined here.
1. `transactions/byUserId`

Get list of transactions by userId, PFB for the request example.

```shell
curl --location --request GET 'http://localhost:8080/transactions/byUserId?userId=1234'
```

2. `transactions/getTransactionHistory`

Get all users' transaction history, PFB for the request example.

```shell
curl --location --request GET 'http://localhost:8080/transactions/getTransactionHistory'
```

3. `transactions/getTransactionById`

Get transaction by transactionId, PFB for the request example.

```shell
curl --location --request GET 'http://localhost:8080/transactions/getTransactionById?transactionId=1'
```

4. `transactions/addTransaction`

Add a transaction for a user with amount, PFB for the request example.

```shell
curl --location --request POST 'http://localhost:8080/transactions/addTransaction' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": 1234,
    "amount": 120.0
}'
```

#### UserController
The base end point for the controller is "users" and we have 4 end points defined here.
1. `users/byUserId`

Get User Details by userId, PFB for the request example.

```shell
curl --location --request GET 'http://localhost:8080/users/byUserId?userId=1235'
```

2. `users/getUsers`

Get all users' details, PFB for the request example.

```shell
curl --location --request GET 'localhost:8080/rewards/getTotalRewards'
```

### Repositories
We have all three necessary repositories in place with all necessary CRUD operations.
1. UserRepository
2. TransactionRepository
3. RewardsRepository

### Initial data
We have added 2 csv files,
1. `classpath:static/users.csv`

List of all users

2. `classpath:static/transactions.csv`

List of transactions

Now in `Loader` class, we have a `PostConstruct` method, `loadDummyData` which loads user data and transaction data from the above-mentioned csv files immediately after the service is up on the mentioned (default) port.

## How to test?

Once we import the code base into IntelliJ, one can navigate into the `main` method of `RewardsprogramApplication` and click on the play button to run the code.
Or one can choose the traditional way and go into the project directory in the terminal, run 
```shell
mvn clean install
```
which will generate a `jar`, and can run the jar with 
```shell
java -jar $JAR_NAME
```
Once the service is up and running on the port 8080, one can import all the requests mentioned above into postman (or directly run on terminal) and from there it's all just hit and get.


