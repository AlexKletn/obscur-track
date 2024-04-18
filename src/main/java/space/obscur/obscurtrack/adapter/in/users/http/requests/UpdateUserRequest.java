package space.obscur.obscurtrack.adapter.in.users.http.requests;

public record UpdateUserRequest(
    String name,
    String role,
    String email
) {}
