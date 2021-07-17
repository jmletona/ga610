package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
}
