package com.berss.platform.iam.domain.services;

import com.berss.platform.iam.domain.model.aggregates.User;
import com.berss.platform.iam.domain.model.commands.CreateUserCommand;
import com.berss.platform.iam.domain.model.commands.RegisterUserWithManagerCommand;
import com.berss.platform.iam.domain.model.commands.SignInCommand;
import com.berss.platform.iam.domain.model.commands.SignInCommand;
import com.berss.platform.iam.domain.model.dto.AuthenticatedUser;
import com.berss.platform.iam.interfaces.rest.resources.RegisterUserWithManagerResource;

import java.util.Optional;

public interface UserCommandService {
    User handle(CreateUserCommand command);
    Optional<AuthenticatedUser> handle(SignInCommand command);
    User handle(RegisterUserWithManagerCommand command);
}
