package com.dlj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dlj.pojo.Role;

import params.RoleParam;

public interface RoleMapper {
	public Role getRole(Long id);

	public List<Role> findRoleByMap(Map<String, String> params);

	public List<Role> findRoleByMaps(@Param("roleName") String rolename, @Param("note") String note);

	public List<Role> findRoleByMap1(RoleParam param);

	public long insertRole(Role role);

	public int upateRole(Role role);

	public int delete(Long id);
}
