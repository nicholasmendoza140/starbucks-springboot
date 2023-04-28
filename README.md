# CMPE 172 Project Journal

## Project Architecture
![Blank diagram](https://user-images.githubusercontent.com/54650478/169574475-1a26d978-90ea-4b90-935a-3f6d532cb5e7.png)


## Creating the Cashier App
Creating the cashier app required creating a model of the Orders, buttons in the view that would trigger an action value to make REST API calls, and the actual API calls themselves. I added in-store drink selection through the use of dropdown menus for the drink, milk, and size options. These selected values would then be set in the "NEW ORDER" call and would create a new order with these customizations. I also implemented a "CLEAR ORDER" call that would clear orders that have not been paid for on the register in the case that a cashier may have messed up an order.

## Cashier App Interface
Initially, I had drink selection and customization on the same page with drop-down menus, but I add more pages to make it more intuitive and visually-appealing. The landing page for the cashier app is just the console and a button to select the drinks and a button to clear the order.

<img width="1440" alt="Screen Shot 2022-05-18 at 6 11 24 PM" src="https://user-images.githubusercontent.com/54650478/169199728-eead990c-0b1d-40e2-8a0b-b5ce30ef3dd0.png">

Displayed here are the drinks with pictures and their names.

<img width="1440" alt="Screen Shot 2022-05-18 at 6 11 31 PM" src="https://user-images.githubusercontent.com/54650478/169199736-ba41cb39-21c8-46aa-b35e-0ca5e9c0a4d2.png">

Upon clicking one of the drinks, the milk and size options can be customized with a button to place the order.

<img width="1440" alt="Screen Shot 2022-05-18 at 6 11 40 PM" src="https://user-images.githubusercontent.com/54650478/169199740-a92e9a75-6bde-4c1d-8df0-e626c3eb04cb.png">

<img width="1440" alt="Screen Shot 2022-05-20 at 9 50 44 AM" src="https://user-images.githubusercontent.com/54650478/169575286-2202708b-0458-4025-96a2-6249b1d9eeff.png">


## Cashier App and Starbucks API Deployed to GCP

Kong API Gateway also used in deployment. We can see the API key configured below.

<img width="1440" alt="Screen Shot 2022-05-18 at 11 23 38 PM" src="https://user-images.githubusercontent.com/54650478/169225397-ad108fe6-e788-472d-88c1-cddad0d90b54.png">

External load balancer for cashier app and internal load balancer for API.

<img width="1440" alt="Screen Shot 2022-05-20 at 6 04 08 PM" src="https://user-images.githubusercontent.com/54650478/169634860-7b792707-ca6e-4bb1-8f73-a01c9d66d689.png">

## CLOUD SQL Connection to API

<img width="1440" alt="Screen Shot 2022-05-18 at 10 13 35 PM" src="https://user-images.githubusercontent.com/54650478/169225667-021652ea-b478-4eea-9bfb-6bb82dbe56a9.png">

## Kong API Key Implementation

The Kong API Key is stored in the application.properties file and was then added as a header in the API calls.

<img width="1440" alt="Screen Shot 2022-05-20 at 10 03 22 AM" src="https://user-images.githubusercontent.com/54650478/169634973-4017f96c-3d34-4457-88c8-bfaad44cacd6.png">

<img width="1440" alt="Screen Shot 2022-05-20 at 10 03 28 AM" src="https://user-images.githubusercontent.com/54650478/169634977-6940d26f-79b6-450e-bfc7-5a35c9ada0e7.png">


## Challenges
The most challenging part of this project was most likely porting the cashier app to a Spring MVC application. That required front end work and learning how to implement the API calls. This was very difficult, but I used Professor Nguyen's Starbucks Client for reference on how to make RESTful API calls.
