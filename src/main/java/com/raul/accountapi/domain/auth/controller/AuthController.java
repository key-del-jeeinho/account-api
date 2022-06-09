package com.raul.accountapi.domain.auth.controller;

import com.raul.accountapi.domain.auth.response.AuthTokenResponse;
import com.raul.accountapi.domain.auth.service.AuthService;
import com.raul.accountapi.domain.auth.type.AuthType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/email/{email}")
    public ResponseEntity<Void> authEmail(@PathVariable String email) {
        authService.startAuthorize(AuthType.EMAIL, email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/phone/{phone}")
    public ResponseEntity<Void> authPhone(@PathVariable String phone) {
        authService.startAuthorize(AuthType.EMAIL, phone);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/admin/{identifier}")
    public ResponseEntity<Void> authAdmin(@PathVariable String identifier) {
        authService.startAuthorize(AuthType.EMAIL, identifier);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{authCode}")
    public ResponseEntity<AuthTokenResponse> getAuthTokenByCode(@PathVariable String authCode) {
        AuthTokenDto dto = authService.authorize(authCode); //인증코드로 인증토큰을 발급한다.
        //발급한 토큰을 응답형식에 맞게 Wrapping한다.
        AuthTokenResponse response = AuthTokenResponse.of(dto);
        return ResponseEntity.ok(response);
    }
}
