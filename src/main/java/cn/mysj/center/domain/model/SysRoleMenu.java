package cn.mysj.center.domain.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sys_role_menu")
public class SysRoleMenu {
    @EmbeddedId
    private SysRoleMenuId id;

    //TODO [逆向工程] 从数据库生成列
}