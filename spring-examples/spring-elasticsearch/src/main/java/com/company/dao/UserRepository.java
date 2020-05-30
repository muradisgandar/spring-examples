package com.company.dao;

import com.company.entity.UserEntity;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<UserEntity,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<UserEntity> getByCustomQuery(String search);

    List<UserEntity>  findByNameLikeOrSurnameLike(String name, String surname);

}
