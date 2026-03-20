package com.ecommerce.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // Generates: getters, setters, toString, equals, hashCode
@Builder            // Generates: builder pattern (ApiResponse.builder().success(true).build())
@NoArgsConstructor  // Generates: empty constructor → new ApiResponse()
@AllArgsConstructor // Generates: full constructor → new ApiResponse(success, message, data)
public class ApiResponse<T> {
    // This class is a "generic" class — the <T> means it can hold ANY type of data.
    // For example: ApiResponse<ProductResponse> or ApiResponse<List<ProductResponse>>
    private boolean success; // Indicates if the API call was successful

    private String message; // A message to provide additional information about the response (e.g., error details)

    private T data; // The actual data being returned (e.g., a product, a list of products, etc.)

    // Static factory methods — shortcuts to create responses
    
    // Call this when something succeeds WITH data
    // Example: ApiResponse.ok("Product fetched", productData)
    public static <T> ApiResponse<T> ok(String message, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }
}
