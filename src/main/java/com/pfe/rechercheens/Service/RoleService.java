package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    Role updateRole(Long id, Role updatedRole);
    void deleteRole(Long id);
    Role getRoleById(Long id);
    List<Role> getAllRoles();
}
