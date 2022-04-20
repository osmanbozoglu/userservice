package com.userservice.userservice.controller;

import com.userservice.userservice.models.AppUser;
import com.userservice.userservice.models.Role;
import com.userservice.userservice.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/appusers")
    public ResponseEntity<List<AppUser>> getAppUsers(){
        return ResponseEntity.ok().body(appUserService.getAppUsers());
    }

    @PostMapping("/appuser/save")
    public ResponseEntity<AppUser> saveAppUser(@RequestBody AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toString());
        return ResponseEntity.created(uri).body(appUserService.saveAppUser(appUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }

    @PostMapping("/role/addroletoappuser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        appUserService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}
