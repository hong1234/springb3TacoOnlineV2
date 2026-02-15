## install

// C:\HONG\2026-IT-WORK\SpringBoot3x\sb3TacoOnline

git clone https://github.com/hong1234/springb3TacoOnlineV2.git

cd springb3TacoOnlineV2

./mvnw spring-boot:run

## User UI App

https://github.com/hong1234/tacoOnlineUI.git

## get all incredients grouped by category for design Form

GET http://localhost:8000/api/v1/ingredient/category

## taco design (make a taco)

POST http://localhost:8000/api/v1/taco/design

// body

{
"name": "My Taco#2",
"ingredients": [1, 2, 3]
}

## get taco by Id

GET http://localhost:8000/api/v1/taco/1

## good doc

https://medium.com/@bectorhimanshu/spring-data-jpa-many-to-many-unidirectional-relationship-mapping-538649df20f6
