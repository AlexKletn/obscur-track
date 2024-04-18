package space.obscur.obscurtrack.adapter.in.users.http.responses;

public record UserResponse(
    String id,
    String name,
    String role,
    String email
) {
}
