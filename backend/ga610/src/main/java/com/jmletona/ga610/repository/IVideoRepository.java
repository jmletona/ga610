package com.jmletona.ga610.repository;

import com.jmletona.ga610.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepository extends JpaRepository<Video, Integer> {
}
