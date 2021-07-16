package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICampusRepository extends JpaRepository<Campus, Integer> {

}
