package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.CampusUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICampusUserRepository extends JpaRepository<CampusUser, Integer> {
}
