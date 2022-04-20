package com.userservice.userservice.service;

import com.userservice.userservice.models.AppUser;
import com.userservice.userservice.models.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveAppUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getAppUser(String username);
    List<AppUser> getAppUsers();
}
