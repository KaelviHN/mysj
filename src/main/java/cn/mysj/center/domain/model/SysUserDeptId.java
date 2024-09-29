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
public class SysUserDeptId implements Serializable {
    @Serial
    private static final long serialVersionUID = -5494269392268657054L;
    @Column(name = "user_id", nullable = false, length = 32)

    private String userId;

    @Column(name = "dept_id", nullable = false, length = 32)
    private String deptId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SysUserDeptId entity = (SysUserDeptId) o;
        return Objects.equals(this.deptId, entity.deptId) &&
               Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, userId);
    }

}