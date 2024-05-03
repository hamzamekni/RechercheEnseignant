package com.pfe.rechercheens.ServiceImpl;

import com.pfe.rechercheens.Entity.Role;
import com.pfe.rechercheens.Repository.RoleRepository;
import com.pfe.rechercheens.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role updatedRole) {
        Role existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole != null) {
            updatedRole.setRoleId(existingRole.getRoleId());
            return roleRepository.save(updatedRole);
        }
        return null;
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
