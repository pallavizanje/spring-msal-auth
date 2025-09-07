# Spring Boot + MSAL + Microsoft Graph Authentication

This project demonstrates **Spring Boot 3 + Spring Security OAuth2 + MSAL** authentication with **Azure AD** and integration with **Microsoft Graph API**.

---

## 🚀 Features
- MSAL OAuth2 login via Microsoft
- User profile retrieval (`/me`)
- User groups retrieval (`/myGroups`)
- Clean architecture (Controller → Service → DTOs)
- WebClient + Lombok

---

## 🔧 Prerequisites
1. Java 17+
2. Maven 3+
3. Azure AD App Registration:
   - Register app in [Azure Portal](https://portal.azure.com)
   - Configure redirect URI: `http://localhost:8080/login/oauth2/code/azure`
   - Grant Microsoft Graph permissions: `User.Read`, `Group.Read.All`

---

## ⚙️ Setup
Update `src/main/resources/application.properties`:
```properties
spring.security.oauth2.client.registration.azure.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.azure.client-secret=YOUR_CLIENT_SECRET
spring.security.oauth2.client.provider.azure.authorization-uri=https://login.microsoftonline.com/YOUR_TENANT_ID/oauth2/v2.0/authorize
spring.security.oauth2.client.provider.azure.token-uri=https://login.microsoftonline.com/YOUR_TENANT_ID/oauth2/v2.0/token
