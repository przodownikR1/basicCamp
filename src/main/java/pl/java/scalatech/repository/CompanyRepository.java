package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{

}
