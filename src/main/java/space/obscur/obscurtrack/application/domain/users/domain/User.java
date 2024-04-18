package space.obscur.obscurtrack.application.domain.users.domain;

public record User(
    String id,
    String name,
    String role,
    String email
) {
}
