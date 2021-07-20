package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {

    @Query(value="select distinct s.* from campus c join country co on c.country_id=co.id"+
                 " join campus_service cs on cs.campus_id = c.id_campus" +
                 " join service s on s.id_service=cs.service_id" +
                 " where co.id = ?1", nativeQuery=true)
    public List<Service> onFetchServices(Integer id);
}
