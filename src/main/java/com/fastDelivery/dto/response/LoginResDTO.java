package com.fastDelivery.dto.response;

import com.fastDelivery.enumerator.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResDTO {

    private String username;
    private Role role;
}
