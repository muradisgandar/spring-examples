package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Notification implements Serializable {

    private String notificationId;
    private Date createdAt;
    private Boolean isSeen;
    private String message;
}
