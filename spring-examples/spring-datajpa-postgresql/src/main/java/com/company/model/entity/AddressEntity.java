package com.company.model.entity;

import com.company.model.AddressEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users_address")
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_users_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_users_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500, name = "address")
    private String address;

    @Enumerated
    private AddressEnum addressEnum;

    @Column(name = "active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "users_address_id")
    private UserEntity userEntity;
}
