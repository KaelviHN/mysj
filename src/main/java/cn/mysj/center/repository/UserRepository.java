package cn.mysj.center.repository;


import cn.mysj.center.domain.model.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<SysUser, String> {
    SysUser findByPhone(String phone);
}