package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.BookingHome;

public interface BookingHomeRepository extends JpaRepository<BookingHome, Long>{

}
