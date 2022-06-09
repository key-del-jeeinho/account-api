package com.raul.accountapi.domain.auth.response;

import com.raul.accountapi.domain.auth.controller.AuthTokenDto;

public record AuthTokenResponse(String authToken) {
    public static AuthTokenResponse of(AuthTokenDto dto) {
        return new AuthTokenResponse(dto.authToken());
    }
}