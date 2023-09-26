package com.example.Swigatto.dto.request;

import com.example.Swigatto.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPartnerRequest {

    String name;

    String mobileNo;

    Gender gender;
}
