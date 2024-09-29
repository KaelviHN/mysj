package cn.mysj.center.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "sys_user")
public class SysUser  {
    @Id
    @Column(name = "id", nullable = false, length = 32)
    private String id;

    @Column(name = "name", nullable = false, length = 180)
    private String name;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "gender", length = 2)
    private String gender;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", length = 180)
    private String email;

    @Column(name = "id_card", nullable = false, length = 18)
    private String idCard;

    @Column(name = "avatar_name")
    private String avatarName;

    @Column(name = "avatar_path")
    private String avatarPath;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "pwd_reset_time")
    private LocalDateTime pwdResetTime;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

}