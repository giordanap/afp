package com.gap.afp.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("customer")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    private String idCustomer;
    private String firstName;
    private String lastName;
    private int dni;
    private int phone;
    private String email;
    private String afp;

}
