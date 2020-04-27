package com.chuilun.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class rolemodule implements Serializable {

    private Integer id;

    private Integer roleId;

    private Integer moduleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "rolemodule{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", moduleId=" + moduleId +
                '}';
    }
}