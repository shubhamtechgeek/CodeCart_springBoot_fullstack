package com.CodeCart.CodeCartbackend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayementInformation {


    @Column(name="cardholder_name")
    private String cardHolderName;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="cvv")
    private String cvv;
}
