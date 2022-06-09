package com.raul.accountapi.domain.auth.service;

import com.raul.accountapi.domain.auth.controller.AuthTokenDto;
import com.raul.accountapi.domain.auth.type.AuthType;

public interface AuthService {
    AuthTokenDto authorize(String authCode);

    void startAuthorize(AuthType email, String identifier);
}
