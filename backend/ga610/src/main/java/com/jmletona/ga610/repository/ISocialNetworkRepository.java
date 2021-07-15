package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocialNetworkRepository extends JpaRepository<SocialNetwork, Integer> {
}
