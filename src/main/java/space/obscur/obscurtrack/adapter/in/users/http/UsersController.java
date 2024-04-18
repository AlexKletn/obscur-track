package space.obscur.obscurtrack.adapter.in.users.http;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import space.obscur.obscurtrack.adapter.in.users.http.requests.CreateUserRequest;
import space.obscur.obscurtrack.adapter.in.users.http.requests.CreateUserRequestMapper;
import space.obscur.obscurtrack.adapter.in.users.http.requests.UpdateUserRequest;
import space.obscur.obscurtrack.adapter.in.users.http.requests.UpdateUserRequestMapper;
import space.obscur.obscurtrack.adapter.in.users.http.responses.UserResponse;
import space.obscur.obscurtrack.adapter.in.users.http.responses.UserResponseMapper;
import space.obscur.obscurtrack.application.port.users.in.GetUserUseCase;
import space.obscur.obscurtrack.application.port.users.in.PushUserUseCase;
import space.obscur.obscurtrack.common.itemsList.ItemsListResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UsersController {
    private final UserResponseMapper userResponseMapper;
    private final CreateUserRequestMapper createUserRequestMapper;
    private final UpdateUserRequestMapper updateUserRequestMapper;

    private final GetUserUseCase getUserUseCase;
    private final PushUserUseCase pushUserUseCase;


    @GetMapping
    public ItemsListResponse<UserResponse> getUser() {
        var usersList = getUserUseCase.getList();
        List<UserResponse> usersResponseList = usersList.getItems().stream().map(userResponseMapper::toResponse).toList();

        return ItemsListResponse.create(usersResponseList, usersList.getTotal());
    }

    @PostMapping
    public void createUser(@RequestBody CreateUserRequest user) {
        pushUserUseCase.push(createUserRequestMapper.toDomainModel(user));
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody UpdateUserRequest userRequest) {

        pushUserUseCase.push(id, updateUserRequestMapper.toDomainModel(userRequest));
    }
}
