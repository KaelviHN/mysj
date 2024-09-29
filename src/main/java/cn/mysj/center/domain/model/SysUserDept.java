package cn.mysj.center.domain.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sys_user_dept")
public class SysUserDept {
    @EmbeddedId
    private SysUserDeptId id;

    //TODO [逆向工程] 从数据库生成列
}