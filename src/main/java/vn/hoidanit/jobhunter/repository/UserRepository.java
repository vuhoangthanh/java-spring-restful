package vn.hoidanit.jobhunter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.jobhunter.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
