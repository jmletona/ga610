package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.PersonService;
import com.jmletona.ga610.model.PersonServiceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonServiceRepository extends JpaRepository<PersonService, PersonServiceId> {
}
