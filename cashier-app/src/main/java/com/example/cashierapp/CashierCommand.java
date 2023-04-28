package com.example.cashierapp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class CashierCommand {

    private String action ;
    private String cardnum ;
    private String cardcode ;
    private String message ;

    private String drink ;
    private String milk ;
    private String size ;

    private String status ;

}