package com.berss.platform.iam.interfaces.rest.transform;

import com.berss.platform.iam.domain.model.aggregates.User;
import com.berss.platform.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {

    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(
                user.getId(),
                user.getUsername(),
                user.getManagerId().getValue(),
                user.getCompanyId().companyId()
        );
    }
}
