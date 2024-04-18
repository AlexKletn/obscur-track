package space.obscur.obscurtrack.adapter.in.users.http.requests;

public record CreateUserRequest (
    String name,
    String role,
    String email
) {}
