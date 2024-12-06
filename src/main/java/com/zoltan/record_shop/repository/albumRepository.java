package com.zoltan.record_shop.repository;

import com.zoltan.record_shop.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface albumRepository extends CrudRepository<Album, Long> {
}
