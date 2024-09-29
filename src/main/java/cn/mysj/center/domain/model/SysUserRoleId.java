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
public class SysUserRoleId implements Serializable {
    @Serial
    private static final long serialVersionUID = 89907878174159897L;
    @Column(name = "user_id", nullable = false, length = 32)
    private String userId;

    @Column(name = "role_id", nullable = false, length = 32)
    private String roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysUserRoleId entity = (SysUserRoleId) o;
        return Objects.equals(this.roleId, entity.roleId) &&
               Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, userId);
    }

}