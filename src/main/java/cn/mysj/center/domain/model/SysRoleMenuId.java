package cn.mysj.center.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class SysRoleMenuId implements Serializable {
    @Serial
    private static final long serialVersionUID = -8149396355395935087L;
    @Column(name = "menu_id", nullable = false, length = 32)
    private String menuId;

    @Column(name = "role_id", nullable = false, length = 32)
    private String roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysRoleMenuId entity = (SysRoleMenuId) o;
        return Objects.equals(this.roleId, entity.roleId) &&
               Objects.equals(this.menuId, entity.menuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, menuId);
    }

}