package com.elvenworks.demospringbootredis.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.elvenworks.demospringbootredis.model.Elf;

@Repository
public interface ElfRepository extends CrudRepository<Elf, String> {}
