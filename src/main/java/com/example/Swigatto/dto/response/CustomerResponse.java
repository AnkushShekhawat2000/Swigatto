package com.example.Swigatto.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    String name;

    String mobileNo;

    String address;





}
