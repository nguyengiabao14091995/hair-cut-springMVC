package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.model.ServiceHair;

public interface ServiceHairRepository extends JpaRepository<ServiceHair, Long> {
	@Query("SELECT s FROM ServiceHair s ORDER BY s.countService DESC")
	List<ServiceHair> findByTop();

}
