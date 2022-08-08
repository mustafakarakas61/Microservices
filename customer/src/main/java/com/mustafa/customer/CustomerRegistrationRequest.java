package com.mustafa.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
