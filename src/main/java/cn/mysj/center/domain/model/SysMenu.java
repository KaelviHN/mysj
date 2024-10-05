package cn.mysj.center.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "sys_menu")
public class SysMenu {
    @Id
    @Column(name = "menu_id", nullable = false, length = 32)
    private String menuId;

    @Column(name = "pid", length = 32)
    private String pid;

    @Column(name = "path")
    private String path;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "menu_sort")
    private Integer menuSort;

    @Column(name = "icon")
    private String icon;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

}