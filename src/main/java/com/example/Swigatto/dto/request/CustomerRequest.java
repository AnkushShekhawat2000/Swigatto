package com.example.Swigatto.dto.request;

import com.example.Swigatto.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CustomerRequest {

    String name;

    String email;

    String address;

    String mobileNo;

    Gender gender;

}
