package com.wineryapp.bodegaapp.repository;
import com.wineryapp.bodegaapp.entity.Vino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VinoRepository extends JpaRepository<Vino, Integer> {
}
