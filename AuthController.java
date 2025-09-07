package com.example.demo.controller;

import com.example.demo.dto.UserProfileDto;
import com.example.demo.service.GraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final GraphService graphService;

    @GetMapping("/login")
    public String loginPage() {
        return "Go to /oauth2/authorization/azure to login with Microsoft";
    }

    @GetMapping("/me")
    public UserProfileDto getUserProfile(@AuthenticationPrincipal OidcUser principal,
                                         @RegisteredOAuth2AuthorizedClient("azure") OAuth2AuthorizedClient client) {
        return graphService.getUserProfile(client);
    }

    @GetMapping("/myGroups")
    public List<String> getUserGroups(@RegisteredOAuth2AuthorizedClient("azure") OAuth2AuthorizedClient client) {
        return graphService.getUserGroups(client);
    }
}
