package com.adamsware.moss.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Session {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String operation;
    private Date date;
    private Integer currentSession;
    private Integer totalSession;
    private Boolean isCompleted;
    private Double price;
    private Double paidAmount;
    private Boolean paymentStatus; //odendi mi? ödenmedi mi??
    private String paymentMethod;
    private String bank;
    private Integer creditCardInstallment; //taksit
    private Date createDate;
    private String note;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
