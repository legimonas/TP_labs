package com.program.tech.task2.source;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryCompanyRepository extends CrudRepository<DeliveryCompany, Long> {

}
