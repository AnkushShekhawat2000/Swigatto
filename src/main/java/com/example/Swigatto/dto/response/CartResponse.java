package com.example.Swigatto.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    double cartTotal;

    List<MenuResponse> foodItems;
}
