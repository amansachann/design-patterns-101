package com.codewithaman.StructuralPattern.FacadePattern.WithoutFacadePattern;

// Microservice for user management
public class UserService {

    public String getUserDetails(String userId) {
        // Simulate fetching user details
        return "User details for userId: " + userId;
    }
}
